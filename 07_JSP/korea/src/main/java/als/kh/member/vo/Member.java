package als.kh.member.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	

	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String  gender;
	private int age;
	private String email;
	private String phone;

}
