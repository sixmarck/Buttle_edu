package account.view;

import java.sql.SQLException;
import java.util.List;

import account.model.AccountDAO;
import account.model.domain.AccountDTO;

public class AccountStartView {

	public static void main(String[] args) {
		try {
			System.out.println("***** 가입 *****");
			AccountDAO.insertAccount(new AccountDTO(1, "2", "2", "2"));
			/*AccountDAO.insertAccount(new AccountDTO(2, "32", "32", "32"));
			AccountDAO.insertAccount(new AccountDTO(3, "5", "52", "52"));
			
			System.out.println("***** 검색 ****");
			System.out.println(AccountDAO.selectAccountById(3));
			
			System.out.println("***** 수정 *****");
			AccountDAO.updateAccount(3, "a@kau.ac.kr");
			
			System.out.println("***** 수정된 결과 검색 *****");
			System.out.println(AccountDAO.selectAccountById(3));
			
			System.out.println("***** 삭제 *****");
			AccountDAO.deleteAccount(3);
			
			System.out.println("***** 모두 검색 *****");
			List all = AccountDAO.selectAllAccounts();
			for (int index = 0; index < all.size(); index++) {
				System.out.println(all.get(index));
			}*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
