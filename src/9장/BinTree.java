
// �����˻�Ʈ��

import java.util.Comparator;

public class BinTree<K, V> {
	// --- ��� ---//
	static class Node<K, V> {
		private K key; // Ű��
		private V data; // ������
		private Node<K, V> left; // ���� ������(���� �ڽĳ�忡 ���� ����)
		private Node<K, V> right; // ������ ������(������ �ڽĳ�忡 ���� ����)

		// --- ������(constructor) ---//
		Node(K key, V data, Node<K, V> left, Node<K, V> right) {
			this.key = key;
			this.data = data;
			this.left = left;
			this.right = right;
		}

		// --- Ű���� ��ȯ ---//
		K getKey() {
			return key;
		}

		// --- �����͸� ��ȯ ---//
		V getValue() {
			return data;
		}

		// --- �����͸� ǥ�� ---//
		void print() {
			System.out.println(data);
		}
	}

	private Node<K, V> root; // ��Ʈ
	private Comparator<? super K> comparator = null; // ����(Comparator)

	// --- ������(constructor) ---//
	public BinTree() {
		root = null;
	}

	// --- ������(constructor) ---//
	public BinTree(Comparator<? super K> c) {
		this();
		comparator = c;
	}

	// --- �� Ű���� �� ---//
	private int comp(K key1, K key2) {
		return (comparator == null) ? ((Comparable<K>) key1).compareTo(key2) : comparator.compare(key1, key2);
	}

	// --- Ű�� �˻� ---//
	public V search(K key) {
		Node<K, V> p = root; // ��Ʈ�� �ָ�

		while (true) {
			if (p == null) // �� �̻� ���ư� �� ������
				return null; // ���˻� ����
			int cond = comp(key, p.getKey()); // key�� ��� p�� Ű�� ��
			if (cond == 0) // ������
				return p.getValue(); // ���˻� ����
			else if (cond < 0) // key ���� ������
				p = p.left; // ������ ����Ʈ������ �˻�
			else // key ���� ũ��
				p = p.right; // �������� ����Ʈ������ �˻�
		}
	}

	// --- node�� �Ѹ��� �ϴ� ����Ʈ���� ��� <K,V>�� ���� ---//
	private void addNode(Node<K, V> node, K key, V data) {
		int cond = comp(key, node.getKey());
		if (cond == 0)
			return; // key�� �����˻�Ʈ���� �̹� ����
		else if (cond < 0) {
			if (node.left == null)
				node.left = new Node<K, V>(key, data, null, null);
			else
				addNode(node.left, key, data); // ���� ����Ʈ���� �ָ�
		} else {
			if (node.right == null)
				node.right = new Node<K, V>(key, data, null, null);
			else
				addNode(node.right, key, data); // ������ ����Ʈ���� �ָ�
		}
	}

	// --- ��� ���� ---//
	public void add(K key, V data) {
		if (root == null)
			root = new Node<K, V>(key, data, null, null);
		else
			addNode(root, key, data);
	}

	// --- Ű���� key�� ��带 ���� --//
	public boolean remove(K key) {
		Node<K, V> p = root; // ��ĵ ���� ���
		Node<K, V> parent = null; // ��ĵ ���� ����� �θ���
		boolean isLeftChild = true; // p�� parent�� ���� �ڽĳ���ΰ�?

		while (true) {
			if (p == null) // �� �̻� ���ư� �� ������
				return false; // ���� Ű���� �������� ����
			int cond = comp(key, p.getKey()); // key�� ��� p�� Ű���� ��
			if (cond == 0) // ������
				break; // ���˻� ����
			else {
				parent = p; // ������ �������� ���� �θ� ����
				if (cond < 0) { // key ���� ������
					isLeftChild = true; // �������� �ڽ����� ������
					p = p.left; // ������ ����Ʈ������ �˻�
				} else { // key ���� ũ��
					isLeftChild = false; // ���������� �ڽ����� ������
					p = p.right; // �������� ����Ʈ������ �˻�
				}
			}
		}

		if (p.left == null) { // p�� ������ �ڽ��� ����
			if (p == root)
				root = p.right;
			else if (isLeftChild)
				parent.left = p.right; // �θ��� ���� �����Ͱ� ������ �ڽ��� ����Ŵ
			else
				parent.right = p.right; // �θ��� ������ �����Ͱ� ������ �ڽ��� ����Ŵ
		} else if (p.right == null) { // p�� ������ �ڽ��� ������
			if (p == root)
				root = p.left;
			else if (isLeftChild)
				parent.left = p.left; // �θ��� ���� �����Ͱ� ���� �ڽ��� ����Ŵ
			else
				parent.right = p.left; // �θ��� ������ �����Ͱ� ���� �ڽ��� ����Ŵ
		} else {
			parent = p;
			Node<K, V> left = p.left; // ����Ʈ�� ��� �ִ� ���
			isLeftChild = true;
			while (left.right != null) { // �ִ� ����� left�� �˻�
				parent = left;
				left = left.right;
				isLeftChild = false;
			}
			p.key = left.key; // left�� Ű���� p�� �̵�
			p.data = left.data; // left�� �����͸� p�� �̵�
			if (isLeftChild)
				parent.left = left.left; // left�� ����
			else
				parent.right = left.left; // left�� ����
		}
		return true;
	}

	// --- node�� ��Ʈ�� �ϴ� ����Ʈ���� ��带 Ű���� ������������ ǥ�� ---//
	private void printSubTree(Node node) {
		if (node != null) {
			printSubTree(node.left); // ���� ����Ʈ���� Ű���� ������������ ǥ��
			System.out.println(node.key + " " + node.data); // node�� ǥ��
			printSubTree(node.right); // ������ ����Ʈ���� Ű���� ������������ ǥ��
		}
	}

	// --- ��ü ��带 Ű���� ������������ ǥ�� ---//
	public void print() {
		printSubTree(root);
	}

	// --- node�� ��Ʈ�� �ϴ� ����Ʈ���� ��带 Ű���� ������������ ǥ�� ---//
	private void printSubTreeReverse(Node node) {
		if (node != null) {
			printSubTreeReverse(node.right); // ������ ����Ʈ���� ������ �ڽĳ����� ���� Ž���ϴ� Ű���� ������������
			System.out.println(node.key + " " + node.data); // node�� ǥ��
			printSubTreeReverse(node.left); // �� �������� ���� ����Ʈ���� Ž��

		}
	}

	public void printReverse() {
		printSubTreeReverse(root);
	}

	// ���� ���� Ű���� ��ȯ
	public K getMinKey() {
		if (root == null) {
			System.out.println("Ʈ���� ����ֽ��ϴ�");
			return null;
		}

		Node<K, V> p = root; // ���� ��Ʈ���� ����

		while (p != null) { // ���� ���� ���� �̵�
			if (p.left == null)
				return p.key;
			p = p.left;
		}
		return null;

	}

	// ���� ���� Ű���� ������ ������ ��ȯ
	public V getDataWithMinKey() {
		if (root == null) {
			System.out.println("Ʈ���� ����ֽ��ϴ�");
			return null;
		}

		Node<K, V> p = root; // ���� ��Ʈ���� ����

		while (p != null) { // ���� ���� ���� �̵�
			if (p.left == null)
				return p.data;
			p = p.left;
		}
		return null;
	}

	// ���� ū Ű���� ��ȯ
	public K getMaxKey() {
		if (root == null) {
			System.out.println("Ʈ���� ����ֽ��ϴ�");
			return null;
		}

		Node<K, V> p = root; // ���� ��Ʈ���� ����

		while (p != null) { // ���� ������ ���� �̵�
			if (p.right == null)
				return p.key;
			p = p.right;
		}
		return null;
	}

	// ���� ū Ű���� ������ �����͸� ��ȯ
	public V getDataWithMaxKey() {
		if (root == null) {
			System.out.println("Ʈ���� ����ֽ��ϴ�");
			return null;
		}

		Node<K, V> p = root; // ���� ��Ʈ���� ����

		while (p != null) { // ���� ������ ���� �̵�
			if (p.right == null)
				return p.data;
			p = p.right;
		}
		return null;
	}
}
