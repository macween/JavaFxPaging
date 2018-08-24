import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PagingController implements Initializable {
	
	@FXML private TableView<MemberVO> tableView;
	@FXML private TableColumn<MemberVO, String> id;
	@FXML private TableColumn<MemberVO, String> name;
	@FXML private TableColumn<MemberVO, String> address;
	
	@FXML private Pagination pagination;
	
	private int from, to, itemsForPage;
	
	private ObservableList<MemberVO> AllTableData, currentPageData;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		id.setCellValueFactory(new PropertyValueFactory<>("id"));		
		name.setCellValueFactory(new PropertyValueFactory<>("name"));		
		address.setCellValueFactory(new PropertyValueFactory<>("address"));	
		
		// 전체 테이블 데이터 설정
		AllTableData = FXCollections.observableArrayList();
		
		AllTableData.add(new MemberVO("1","홍길동1", "대전시 중구 대흥동 대덕인재개발원"));
		AllTableData.add(new MemberVO("2","홍길동2", "대전시 중구 대흥동 대덕인재개발원"));
		AllTableData.add(new MemberVO("3","홍길동3", "대전시 중구 대흥동 대덕인재개발원"));
		AllTableData.add(new MemberVO("4","홍길동4", "대전시 중구 대흥동 대덕인재개발원"));
		AllTableData.add(new MemberVO("5","홍길동5", "대전시 중구 대흥동 대덕인재개발원"));
		AllTableData.add(new MemberVO("6","홍길동6", "대전시 중구 대흥동 대덕인재개발원"));
		AllTableData.add(new MemberVO("7","홍길동7", "대전시 중구 대흥동 대덕인재개발원"));
		AllTableData.add(new MemberVO("8","홍길동8", "대전시 중구 대흥동 대덕인재개발원"));
		AllTableData.add(new MemberVO("9","홍길동9", "대전시 중구 대흥동 대덕인재개발원"));
		AllTableData.add(new MemberVO("10","홍길동10", "대전시 중구 대흥동 대덕인재개발원"));
		AllTableData.add(new MemberVO("11","홍길동11", "대전시 중구 대흥동 대덕인재개발원"));
		AllTableData.add(new MemberVO("12","홍길동12", "대전시 중구 대흥동 대덕인재개발원"));
		AllTableData.add(new MemberVO("13","홍길동13", "대전시 중구 대흥동 대덕인재개발원"));
		AllTableData.add(new MemberVO("14","홍길동14", "대전시 중구 대흥동 대덕인재개발원"));
		AllTableData.add(new MemberVO("15","홍길동15", "대전시 중구 대흥동 대덕인재개발원"));
		AllTableData.add(new MemberVO("16","홍길동16", "대전시 중구 대흥동 대덕인재개발원"));
		
		
		itemsForPage = 5; // 한페이지 보여줄 항목 수 설정
		int totPageCount = AllTableData.size()%itemsForPage == 0 ? AllTableData.size()/itemsForPage : AllTableData.size()/itemsForPage + 1;
		pagination.setPageCount(totPageCount); // 전체 페이지 수 설정
		
		pagination.setPageFactory(this::createPage);
		
	}
	
	/**
	 * 페이징 처리를 위한 팩토리 메서드
	 * @param pageIndex
	 * @return
	 */
	private Node createPage(int pageIndex){
		
		from = pageIndex * itemsForPage;
		to = from + itemsForPage - 1;
		tableView.setItems(getTableViewData(from, to));
		
		return tableView;
	}
	
	/**
	 * TableView에 채워줄 데이터를 가져오는 함수
	 * @param from
	 * @param to
	 * @return
	 */
	private ObservableList<MemberVO> getTableViewData(int from, int to){
		
		currentPageData = FXCollections.observableArrayList(); // 현재페이지 데이터 초기화
		int totSize = AllTableData.size();
		for(int i = from; i <= to && i <totSize; i++){
		
			currentPageData.add(AllTableData.get(i));
		}
		
		return currentPageData;
	}
	
	

}
