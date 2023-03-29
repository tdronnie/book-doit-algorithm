
// 연결 리스트 클래스

import java.util.Comparator;

public class LinkedList<E> {
	// --- 노드 ---//
	class Node<E> {
		private E data; // 데이터
		private Node<E> next; // 뒤쪽 포인터(다음 노드에 대한 참조)

		// --- 생성자(constructor) ---//
		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E> head; // 머리 포인터(머리 노드에 대한 참조)
	private Node<E> crnt; // 선택 포인터(선택 노드에 대한 참조)

	// --- 생성자(constructor) ---//
	public LinkedList() {
		head = crnt = null;
	}

	// --- 노드 검색 ---//
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head; // 현재 스캔 중인 노드

		while (ptr != null) {
			if (c.compare(obj, ptr.data) == 0) { // 검색 성공
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next; // 뒤쪽 노드에 주목
		}
		return null; // 검색 실패
	}

	// --- 머리 노드 삽입 ---//
	public void addFirst(E obj) {
		Node<E> ptr = head; // 삽입 전의 머리 노드
		head = crnt = new Node<E>(obj, ptr);
	}

	// --- 꼬리 노드 삽입 ---//
	public void addLast(E obj) {
		if (head == null) // 리스트가 비어있으면
			addFirst(obj); // 머리에 삽입
		else {
			Node<E> ptr = head;
			while (ptr.next != null)
				ptr = ptr.next;
			ptr.next = crnt = new Node<E>(obj, null);
		}
	}

	// --- 머리노드 삭제 ---//
	public void removeFirst() {
		if (head != null) // 리스트가 비어있지 않으면
			head = crnt = head.next;
	}

	// --- 꼬리노드 삭제 ---//
	public void removeLast() {
		if (head != null) {
			if (head.next == null) // 노드가 하나만 있으면
				removeFirst(); // 머리노드 삭제
			else {
				Node<E> ptr = head; // 스캔 중인 노드
				Node<E> pre = head; // 스캔 중인 노드의 앞쪽 노드

				while (ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = null; // pre는 삭제 뒤의 꼬리 노드
				crnt = pre;
			}
		}
	}

	// --- 노드p 삭제 ---//
	public void remove(Node p) {
		if (head != null) {
			if (p == head) // p가 머리 노드이면
				removeFirst(); // 머리 노드 삭제
			else {
				Node<E> ptr = head;

				while (ptr.next != p) {
					ptr = ptr.next;
					if (ptr == null)
						return; // p가 리스트에 없음
				}
				ptr.next = p.next;
				crnt = ptr;
			}
		}
	}

	// --- 선택 노드 삭제 ---//
	public void removeCurrentNode() {
		remove(crnt);
	}

	// --- 전체노드 삭제 ---//
	public void clear() {
		while (head != null) // 비게 될 때까지
			removeFirst(); // 머리 노드 삭제
		crnt = null;
	}

	// --- 선택 노드를 하나 뒤쪽으로 진행 ---//
	public boolean next() {
		if (crnt == null || crnt.next == null)
			return false; // 나아갈 수 없음
		crnt = crnt.next;
		return true;
	}

	// --- 선택 노드 표시 ---//
	public void printCurrentNode() {
		if (crnt == null)
			System.out.println("주목노드가 없습니다.");
		else
			System.out.println(crnt.data);
	}

	// --- 전체 노드 표시 ---//
	public void dump() {
		Node<E> ptr = head;

		while (ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}

	// ---【연습8-1】 컴퍼레이터c로 서로 같은 노드를 찾아 모든 노드를 삭제 ---//
	public void purge(Comparator<? super E> c) {
		Node<E> ptr = head; //처음부터 검색위한 포인터 설정

		while (ptr != null) { //선형 검색
			int count = 0;
			Node<E> ptr2 = ptr; //비교 포인터
			Node<E> pre = ptr; //탐색 포인터

			while (pre.next != null) {
				ptr2 = pre.next; //비교하기 위한 포인터를 탐색한 그다음 포인터로 변경
				if (c.compare(ptr.data, ptr2.data) == 0) { //타겟 데이터와 같은 비교 포인터의 데이터와 같을 경우
					pre.next = ptr2.next; //삭제 위해 다음 참조지점을 그 다음으로 넘김
					count++; //중복되는 노드 개수 + 1
				} else
					pre = ptr2; //탐색 포인터를  비교완료한 포인터로 업데이트
			}
			if (count == 0) //중복되는 노드가 없었다면
				ptr = ptr.next; //다음으로 포인터 넘김
			else {
				Node<E> temp = ptr; //현재 포인터 저장해두고
				remove(ptr); //현재 포인터 노드 삭제
				ptr = temp.next; //현재 포인터를 다음 포인터로 업데이트
			}
		}
		crnt = head; //현재 포인터를 머리노드 포인터로 다시 업데이트 해놓는다.
	}

	// ---【연습8-2】 머리부터 n개 뒤 노드의 데이터에 대한 참조를 반환 ---//
	public E retrieve(int n) {
		Node<E> ptr = head; //처음부터 검색

		while (n >= 0 && ptr != null) { //n번 남은 동안, 포인터 null전까지
			if (n-- == 0) { //n이 0될 때까지 마이너스
				crnt = ptr; //움직인 포인터를 현재 포인터로 업데이트
				return ptr.data; // 검색 성공
			}
			ptr = ptr.next; // 다음 노드를 선택
		}
		return null; //n번 뒤의 노드가 없거나
	}
}