package Final_TCP;
//2015112232백근주
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class Final_Client {

	static Vector<Integer> sc_num = new Vector<Integer>(); // 학번
	static Vector<String> name = new Vector<String>(); // 이름
	static Vector<Integer> attend = new Vector<Integer>(); // 출석
	static Vector<Integer> hw = new Vector<Integer>(); // 과제
	static Vector<Integer> mid = new Vector<Integer>(); // 중간
	static Vector<Integer> fin = new Vector<Integer>(); // 기말
	static Vector<Integer> sum = new Vector<Integer>(); // 합계
	static Vector<Integer> rank = new Vector<Integer>(); // 순위

	public static boolean inputData(String[] sub_data) {
		// 중복 확인 한 뒤에 vector에 삽입
		// 그 뒤에 DB에 insert

		// 학번을 비교하여 중복 여부 확인
		if (sc_num.contains(Integer.valueOf(sub_data[0]))) {
			System.out.println("중복된 데이터입니다");
			return false;
		}
		// 중복이 아니라면 벡터들에게 저장
		sc_num.add(Integer.valueOf(sub_data[0]));
		name.add(sub_data[1]);
		attend.add(Integer.valueOf(sub_data[2]));
		hw.add(Integer.valueOf(sub_data[3]));
		mid.add(Integer.valueOf(sub_data[4]));
		fin.add(Integer.valueOf(sub_data[5]));

		int total = Integer.valueOf(sub_data[2]) + Integer.valueOf(sub_data[3]) + Integer.valueOf(sub_data[4])
				+ Integer.valueOf(sub_data[5]);
		sum.add(total); // 토탈 합
		rank.add(1); // 1등으로 초기화

		return true;
	}

	public static void rank() {
		// 합계값들을 비교하여 순위를 정한다.

		for (int i = 0; i < sum.size() - 1; i++) {
			if (sum.get(i) < sum.lastElement()) {
				// 값이 신규 합계값보다 작으면 순위를 증가시킨다.
				rank.set(i, rank.get(i) + 1);
			} else if (sum.get(i) > sum.lastElement()) {
				// 값이 신규 합계값보다 크면 신규 순위를 증가시킨다.
				rank.set(sum.size() - 1, rank.get(sum.size() - 1) + 1);
			}
		}
	}

	public static String inputDB(String[] sub_data) {
		// DB에 insert
		String sql = "INSERT INTO student VALUES(" + sub_data[0] + ",'" + sub_data[1] + "'," + sub_data[2] + ","
				+ sub_data[3] + "," + sub_data[4] + "," + sub_data[5] + "," + sum.lastElement() + ","
				+ rank.lastElement() + ")";
		// System.out.println(sql);

		return sql;
	}

	public static String show(int choose) {
		Scanner sc = new Scanner(System.in);
		String name;
		int min;
		int max;
		int select;
		int number;

		if (choose == 1) {
			// 학번 출력 sn
			while (true) {
				System.out.println("특정:1, 범위:2");
				String str_num = sc.nextLine();
				if (check(str_num)) {
					select = Integer.parseInt(str_num);
					break;
				}
				System.out.println("다시입력");
			}
			// 특정 이라면 정수 값 한개 입력
			if (select == 1) {
				while (true) {
					System.out.print("특정 값 입력: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						number = Integer.parseInt(str_num);
						break;
					}
					System.out.println("다시입력");
				}
				return subshow1("sn", number);

			} else { // 아니라면 min max 입력
				while (true) {
					System.out.print("min: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						min = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n다시입력");
				}
				while (true) {
					System.out.print("max: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						max = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n다시입력");
				}
				return subshow2("sn", min, max);
			}
		} else if (choose == 2) {
			// 성명 출력 name
			while (true) {
				System.out.print("이름입력: ");
				String str_num = sc.nextLine();
				if (!check(str_num)) {
					name = str_num;
					break;
				}
				System.out.println("\n다시입력");
			}
			return subshow3("name", name);

		} else if (choose == 3) {
			// 출석 출력 attend
			while (true) {
				System.out.println("특정:1, 범위:2");
				String str_num = sc.nextLine();
				if (check(str_num)) {
					select = Integer.parseInt(str_num);
					break;
				}
				System.out.println("다시입력");
			}
			// 특정 이라면 정수 값 한개 입력
			if (select == 1) {
				while (true) {
					System.out.print("특정 값 입력: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						number = Integer.parseInt(str_num);
						break;
					}
					System.out.println("다시입력");
				}
				return subshow1("attend", number);

			} else { // 아니라면 min max 입력
				while (true) {
					System.out.print("min: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						min = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n다시입력");
				}
				while (true) {
					System.out.print("max: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						max = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n다시입력");
				}
				return subshow2("attend", min, max);
			}
		} else if (choose == 4) {
			// 과제 출력 hw
			while (true) {
				System.out.println("특정:1, 범위:2");
				String str_num = sc.nextLine();
				if (check(str_num)) {
					select = Integer.parseInt(str_num);
					break;
				}
				System.out.println("다시입력");
			}
			// 특정 이라면 정수 값 한개 입력
			if (select == 1) {
				while (true) {
					System.out.print("특정 값 입력: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						number = Integer.parseInt(str_num);
						break;
					}
					System.out.println("다시입력");
				}
				return subshow1("hw", number);

			} else { // 아니라면 min max 입력
				while (true) {
					System.out.print("min: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						min = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n다시입력");
				}
				while (true) {
					System.out.print("max: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						max = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n다시입력");
				}
				return subshow2("hw", min, max);
			}
		} else if (choose == 5) {
			// 중간 출력 mid
			while (true) {
				System.out.println("특정:1, 범위:2");
				String str_num = sc.nextLine();
				if (check(str_num)) {
					select = Integer.parseInt(str_num);
					break;
				}
				System.out.println("다시입력");
			}
			// 특정 이라면 정수 값 한개 입력
			if (select == 1) {
				while (true) {
					System.out.print("특정 값 입력: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						number = Integer.parseInt(str_num);
						break;
					}
					System.out.println("다시입력");
				}
				return subshow1("mid", number);

			} else { // 아니라면 min max 입력
				while (true) {
					System.out.print("min: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						min = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n다시입력");
				}
				while (true) {
					System.out.print("max: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						max = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n다시입력");
				}
				return subshow2("mid", min, max);
			}
		} else if (choose == 6) {
			// 기말 출력 fin
			while (true) {
				System.out.println("특정:1, 범위:2");
				String str_num = sc.nextLine();
				if (check(str_num)) {
					select = Integer.parseInt(str_num);
					break;
				}
				System.out.println("다시입력");
			}
			// 특정 이라면 정수 값 한개 입력
			if (select == 1) {
				while (true) {
					System.out.print("특정 값 입력: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						number = Integer.parseInt(str_num);
						break;
					}
					System.out.println("다시입력");
				}
				return subshow1("fin", number);

			} else { // 아니라면 min max 입력
				while (true) {
					System.out.print("min: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						min = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n다시입력");
				}
				while (true) {
					System.out.print("max: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						max = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n다시입력");
				}
				return subshow2("fin", min, max);
			}
		} else if (choose == 7) {
			// 합계 출력 sum
			while (true) {
				System.out.println("특정:1, 범위:2");
				String str_num = sc.nextLine();
				if (check(str_num)) {
					select = Integer.parseInt(str_num);
					break;
				}
				System.out.println("다시입력");
			}
			// 특정 이라면 정수 값 한개 입력
			if (select == 1) {
				while (true) {
					System.out.print("특정 값 입력: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						number = Integer.parseInt(str_num);
						break;
					}
					System.out.println("다시입력");
				}
				return subshow1("sum", number);

			} else { // 아니라면 min max 입력
				while (true) {
					System.out.print("min: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						min = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n다시입력");
				}
				while (true) {
					System.out.print("max: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						max = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n다시입력");
				}
				return subshow2("sum", min, max);
			}
		} else if (choose == 8) {
			// 등수 출력 rank
			while (true) {
				System.out.println("특정:1, 범위:2");
				String str_num = sc.nextLine();
				if (check(str_num)) {
					select = Integer.parseInt(str_num);
					break;
				}
				System.out.println("다시입력");
			}
			// 특정 이라면 정수 값 한개 입력
			if (select == 1) {
				while (true) {
					System.out.print("특정 값 입력: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						number = Integer.parseInt(str_num);
						break;
					}
					System.out.println("다시입력");
				}
				return subshow1("rank", number);

			} else { // 아니라면 min max 입력
				while (true) {
					System.out.print("min: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						min = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n다시입력");
				}
				while (true) {
					System.out.print("max: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						max = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n다시입력");
				}
				return subshow2("rank", min, max);
			}
		} else if(choose == 9){
			//전부 반환
			return "SELECT * FROM STUDENT;";
		}else {
			System.out.println("다시 입력하세요");
			return null;
		}
	}

	public static String subshow1(String column, int select) {
		// show함수의 서브함수
		return "SELECT * FROM STUDENT WHERE " + column + " = " + select + ";";
	}

	public static String subshow2(String column, int min, int max) {
		// show함수의 서브함수
		return "SELECT * FROM STUDENT WHERE " + column + " BETWEEN " + min + " AND " + max + ";";
	}

	public static String subshow3(String column, String name) {
		// show함수의 서브함수
		return "SELECT * FROM STUDENT WHERE " + column + " = '" + name + "';";
	}

	public static String rankupdate(int i) {
		// 등수 업데이트
		String sql;
		sql = "UPDATE student SET rank=";
		sql = sql + rank.get(i);
		sql = sql + " WHERE sn= ";
		sql = sql + sc_num.get(i) + ";";
		return sql;

	}

	public static boolean check(String s) {
		// 숫자인지 아닌지 구별해주는 함수
		try {
			double n = Double.parseDouble(s);
			return true;// 숫자일때
		} catch (NumberFormatException e) {
			return false;// 문자일때
		}
	}

	public static void main(String[] args) {
		OutputStreamWriter osw = null;
		InputStreamReader isr = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		OutputStream os = null;
		InputStream is = null;

		Socket socket = null;
		String serIp = "127.0.0.1"; // 아이피
		int port = 8080; // 포트번호
		int choose;

		String str_num;
		Scanner sc = new Scanner(System.in);
		String data; // 데이터 저장
		String[] sub_data;// split된 데이터 저장
		String sql; // sql문 저장
		String receiveData = ""; // 서버 데이터 저장 변수

		try {
			socket = new Socket(serIp, port);

			os = socket.getOutputStream(); // 서버 전송을 위한 outputstream
			osw = new OutputStreamWriter(os);
			pw = new PrintWriter(osw);

			is = socket.getInputStream(); // 서버로부터 Data 받기
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);

		} catch (IOException e) {
			System.out.println("소켓 생성 실패");
		}

		// 테이블 없으면 테이블 생성
		try {
			String table = "CREATE table if not exists STUDENT"
					+ "(sn int,name varchar(20),attend int,hw int,mid int,fin int,sum int,rank int);";
			pw.println(table);
			pw.flush();// 내용을 전송하고 버퍼를 비운다.
			Thread.sleep(1000); // 시간을 주어서 업데이트 할수 있게 만든다.
			pw.println("ALTER TABLE student convert to charset utf8;");// 한글도 받을수 있게 한다.
			pw.flush();
		} catch (InterruptedException e) {
			System.out.println("테이블 생성 및 설정 오류");
		}

		do {
			while (true) {
				System.out.println("신규입력:1, 출력:2, 종료:3>>");
				str_num = sc.nextLine();
				if (check(str_num)) {
					choose = Integer.parseInt(str_num);
					break;
				}
				System.out.println("다시입력");
			}

			if (choose == 1) {
				System.out.println("1.신규입력");
				System.out.println("학번, 성명, 출석, 과제, 중간, 기말 입력: ");
				// 데이터 입력받기
				data = sc.nextLine();
				sub_data = data.split(",");
				// 만일 조건과 안맞으면 처음부터
				if (sub_data.length != 6) {
					System.out.println("다시입력");
					continue;
				}
				if (!check(sub_data[0])) {
					System.out.println("다시입력");
					continue;
				} else if (check(sub_data[1])) {
					System.out.println("다시입력");
					continue;
				} else if (!check(sub_data[2])) {
					System.out.println("다시입력");
					continue;
				} else if (!check(sub_data[3])) {
					System.out.println("다시입력");
					continue;
				} else if (!check(sub_data[4])) {
					System.out.println("다시입력");
					continue;
				} else if (!check(sub_data[5])) {
					System.out.println("다시입력");
					continue;
				}

				if (inputData(sub_data)) {
					// 데이터가 정상적으로 입력되었다면
					// 서버 전송
					sql = inputDB(sub_data);
					// 서버 전송하고 비우기
					pw.println(sql);
					pw.flush();
					// 순위 조정
					rank();

					// 등수 업데이트
					try {
						for (int i = 0; i < rank.size(); i++) {
							sql = rankupdate(i);
							pw.println(sql);
							pw.flush();
							Thread.sleep(500); // 시간을 주어서 업데이트 할수 있게 만든다.
						}
					} catch (InterruptedException e) {
						System.out.println("rankupdate 오류");
					}

					// 서버에서 데이터 받기
					try {
						Thread.sleep(20); // 시간을 주어서 업데이트 할수 있게 만든다.
						System.out.println("입력 성공");
						pw.println("입력 성공");
						pw.flush();

					} catch (InterruptedException e) {
						System.out.println("데이터 전송 오류");
					}

				} else {
					// 만약 아니라면
					try {
						Thread.sleep(20); // 시간을 주어서 업데이트 할수 있게 만든다.
						System.out.println("중복 오류 : 입력 실패");
						pw.println("중복 오류 : 입력 실패");
						pw.flush();
					} catch (InterruptedException e) {
						System.out.println("데이터 전송 오류");
					}
				}
			} else if (choose == 2) {
				System.out.println("2.출력");
				while (true) {
					System.out.println("학번:1, 성명:2, 출석:3, 과제:4, 중간:5,\n기말:6, 합계:7 ,등수:8 ,전부:9");
					str_num = sc.nextLine();
					if (check(str_num)) {// 올바른 값 입력
						choose = Integer.parseInt(str_num);
						break;
					}
					System.out.println("다시입력");
				}
				try {
					Thread.sleep(20); // 시간을 주어서 업데이트 할수 있게 만든다.
					sql = show(choose); // sql문 입력
					pw.println(sql);
					pw.flush();
					Thread.sleep(1000);
					while (br.ready()) { // 준비되면 출력
						receiveData = br.readLine();
						System.out.println(receiveData);
						Thread.sleep(30);
					}
				} catch (InterruptedException e) {
					System.out.println("데이터 전송 오류");
				} catch (IOException e) {
					System.out.println("IOException");
				}

			} else if (choose == 3) {
				System.out.println("3.종료"); // 서버도 종료하기 위해 3을 보낸다
				pw.println(choose);
				pw.close();
				return;
			} else {
				System.out.println("다시 입력하세요");
			}

		} while (choose != 3);

		try {
			br.close();
			isr.close();
			is.close();
			pw.close();
			osw.close();
			os.close();
		} catch (Exception e) {
			System.out.println("close 오류");
		}

		return;
	}

}
