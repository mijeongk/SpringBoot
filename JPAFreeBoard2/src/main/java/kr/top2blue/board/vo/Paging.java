package kr.top2blue.board.vo;
// 알고리즘은 동일하고 자료형만 다를경우 제네릭 클래스를 만들어 사용하면 편리하다.

import java.util.List;

public class Paging<T> {
	// 페이징할 대상을 저장할 리스트
	private List<T> list; // 1페이지 분량의 내용을 저장할 리스트
	
	// 4개의 변수는 생성자로 넘겨 받는다.
	private int totalCount; 	// 전체 글 수
	private int currentPage; 	// 현재 페이지
	private int sizeOfPage; 	// 페이지당 글수
	private int sizeOfBlock;    // 하단에 페이지번호 몇개씩 출력 
	
	// 전체 : 000개(현재페이지/전체페이지수 페이지)
	// 나머지 변수들은 계산을 한다.
	private int totalPage;		// 전체 페이지수
	private int startNo;		// 시작 글번호
	private int endNo;			// 끝 글번호
	private int startPage;		// 표시할 시작 페이지 번호
	private int endPage;		// 표시할 끝 페이지 번호
	
	// 4개의 변수는 생성자로 넘겨 받는다.
	public Paging(int totalCount, int currentPage, int sizeOfPage, int sizeOfBlock) {
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.sizeOfPage = sizeOfPage;
		this.sizeOfBlock = sizeOfBlock;
		
		// 나머지 변수들은 계산해서 넣는다.
		calc();
	}

	private void calc() {
		// 넘겨 받은 값의 유효성을 검사한다.
		// 현재페이지는 1보다 적을 수 없다.
		if(currentPage<1) currentPage = 1;
		// 페이지당 글수는 2보다 적을 수 없다
		if(sizeOfPage<2) sizeOfPage = 10;
		// 페이지 표시 개수도 2보다 적을 수 없다
		if(sizeOfBlock<2) sizeOfBlock = 10;
		// 내용이 있을때만 페이지를 계산한다,
		if(totalCount>0) {
			// 전체 페이지수 = (전체개수 -1)/페이지당개수 + 1
			totalPage = (totalCount-1) / sizeOfPage + 1;
			// 현재 페이지가 전체페이지 보다 클수 없다.
			if(currentPage>totalPage) currentPage = 1;
			// 시작번호  = (현재페이지-1)*페이지당개수 + 1 ; // 인덱스가 0부터 시작하는 DB는 +1을 안한다.
			// 1 페이지 :  1 ~ 10
			// 2 페이지 : 11 ~ 20
			// 3 페이지 : 21 ~ 30
			// 4 페이지 : 31 ~ 40
			startNo = (currentPage-1)*sizeOfPage + 1;
			// 끝번호  = 시작번호 + 페이지당글수 -1
			endNo = startNo + sizeOfPage -1;
			// 끝번호는 전체 글수를 넘을 수 없다.
			if(endNo>totalCount) endNo = totalCount;
			// 시작 페이지 번호 = (현재페이지번호-1)/블록수*블럭수 + 1
			// 현재페이지
			//   5       (5-1)/10 * 10 + 1 = 1
			//   9       (9-1)/10 * 10 + 1 = 1
			//   10      (10-1)/10 * 10 + 1 = 1
			//   11      (11-1)/10 * 10 + 1 = 11
			startPage = (currentPage-1)/sizeOfBlock * sizeOfBlock + 1;
			// 끝페이지번호 = 시작페이지 번호 + 블록개수 - 1
			endPage = startPage + sizeOfBlock -1;
			// 마지막 페이지 번호는 전체 페이지 번호를 넘을 수 없다
			if(endPage>totalPage) endPage = totalPage;
		}
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getSizeOfPage() {
		return sizeOfPage;
	}

	public int getSizeOfBlock() {
		return sizeOfBlock;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getStartNo() {
		return startNo;
	}

	public int getEndNo() {
		return endNo;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	@Override
	public String toString() {
		return "Paging [list=" + list + ", totalCount=" + totalCount + ", currentPage=" + currentPage + ", sizeOfPage="
				+ sizeOfPage + ", sizeOfBlock=" + sizeOfBlock + ", totalPage=" + totalPage + ", startNo=" + startNo
				+ ", endNo=" + endNo + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	

	public static void main(String[] args) {
		Paging<String> paging = new Paging<>(123, 13, 10, 10);
		System.out.println(paging);
		System.out.println(paging.getPageInfo());
		System.out.println(paging.getPageList());
	}
	
	// 메서드 2개를 추가해보자
	// 상단에 페이지 정보를 출력해주는 메서드
	public String getPageInfo() {
		String result = "전체 : " + totalCount + "개";
		if(totalCount>0) {
			result += "(" + currentPage + "/" + totalPage + "Page)";
		}
		return result;
	}
	// 하단에 페이지 이동을 만들어 주는 메서드
	public String getPageList() {
		StringBuilder sb = new StringBuilder();
			if(totalCount>0) {
			// 시작페이지 번호가 1보다 크다면 [이전]이 존재한다.
			if(startPage>1) {
				// 현재 페이지에 링크를 걸려면 주소가 ?로 시작하면 된다.
				sb.append("[<a href='?p=" + (startPage-1) + 
						"&s=" + sizeOfPage + "&b=" + sizeOfBlock + "'>이전</a>] ");
			}
			// 페이지 번호 출력
			for(int i = startPage;i<=endPage;i++) {
				// 현재 페이지는 링크를 걸지 않는다.
				if(i==currentPage) {
					sb.append("[" + i + "] ");
				}else {
					sb.append("[<a href='?p=" + (i) + 
							"&s=" + sizeOfPage + "&b=" + sizeOfBlock + "'>"+i+"</a>] ");
				}
			}
			// 마지막페이지 번호가 전체 페이지 번호보다 적다면 [다음]이 존재한다.
			if(endPage<totalPage) {
				// 현재 페이지에 링크를 걸려면 주소가 ?로 시작하면 된다.
				sb.append("[<a href='?p=" + (endPage+1) + 
						"&s=" + sizeOfPage + "&b=" + sizeOfBlock + "'>다음</a>]");
			}
		}
		return sb.toString();
	}
	// 부트 스트랩을 이용한 페이지네이션
	public String getPageList2() {
		StringBuilder sb = new StringBuilder();
		if(totalCount>0) {
			sb.append("<nav aria-label='Page navigation example'>");
			// 이전
			sb.append("<ul class='pagination pagination-sm justify-content-center my'>");
			if(startPage>1) {
				sb.append("<li class='page-item'>");
				sb.append("   <a class='page-link' href='?p=" + (startPage-1) + 
						"&s=" + sizeOfPage + "&b=" + sizeOfBlock + "' aria-label='Previous'>");
				sb.append("     <span aria-hidden='true'>🍜</span>");
				sb.append("   </a>");
				sb.append("</li>");
			}
			// 페이지 번호
			for(int i = startPage;i<=endPage;i++) {
				if(i==currentPage) {
					sb.append("<li class='page-item active' aria-current='page'>");
					sb.append("   <a class='page-link' href='#'>");
					sb.append(i);
					sb.append("   </a>");
					sb.append("</li>");
				}else {
					sb.append("<li class='page-item'>");
					sb.append("   <a class='page-link' href='?p=" + i
							+ "&s=" + sizeOfPage + "&b=" + sizeOfBlock + "'>");
					sb.append(i);
					sb.append("   </a>");
					sb.append("</li>");
				}
			}
			// 다음
			// 마지막페이지 번호가 전체 페이지 번호보다 적다면 [다음]이 존재한다.
			if(endPage<totalPage) {
				sb.append("<li class='page-item'>");
				sb.append("   <a class='page-link' href='?p=" + (endPage+1) + 
						           "&s=" + sizeOfPage + "&b=" + sizeOfBlock +
						           "' aria-label='Next'>");
				sb.append("     <span aria-hidden='true'>🍗</span>");
				sb.append("   </a>");
				sb.append("</li>");
			}
			sb.append("</ul>");
			sb.append("</nav>");
		}
		return sb.toString();
	}
	
	
}
