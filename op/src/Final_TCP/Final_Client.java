package Final_TCP;
//2015112232�����
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

	static Vector<Integer> sc_num = new Vector<Integer>(); // �й�
	static Vector<String> name = new Vector<String>(); // �̸�
	static Vector<Integer> attend = new Vector<Integer>(); // �⼮
	static Vector<Integer> hw = new Vector<Integer>(); // ����
	static Vector<Integer> mid = new Vector<Integer>(); // �߰�
	static Vector<Integer> fin = new Vector<Integer>(); // �⸻
	static Vector<Integer> sum = new Vector<Integer>(); // �հ�
	static Vector<Integer> rank = new Vector<Integer>(); // ����

	public static boolean inputData(String[] sub_data) {
		// �ߺ� Ȯ�� �� �ڿ� vector�� ����
		// �� �ڿ� DB�� insert

		// �й��� ���Ͽ� �ߺ� ���� Ȯ��
		if (sc_num.contains(Integer.valueOf(sub_data[0]))) {
			System.out.println("�ߺ��� �������Դϴ�");
			return false;
		}
		// �ߺ��� �ƴ϶�� ���͵鿡�� ����
		sc_num.add(Integer.valueOf(sub_data[0]));
		name.add(sub_data[1]);
		attend.add(Integer.valueOf(sub_data[2]));
		hw.add(Integer.valueOf(sub_data[3]));
		mid.add(Integer.valueOf(sub_data[4]));
		fin.add(Integer.valueOf(sub_data[5]));

		int total = Integer.valueOf(sub_data[2]) + Integer.valueOf(sub_data[3]) + Integer.valueOf(sub_data[4])
				+ Integer.valueOf(sub_data[5]);
		sum.add(total); // ��Ż ��
		rank.add(1); // 1������ �ʱ�ȭ

		return true;
	}

	public static void rank() {
		// �հ谪���� ���Ͽ� ������ ���Ѵ�.

		for (int i = 0; i < sum.size() - 1; i++) {
			if (sum.get(i) < sum.lastElement()) {
				// ���� �ű� �հ谪���� ������ ������ ������Ų��.
				rank.set(i, rank.get(i) + 1);
			} else if (sum.get(i) > sum.lastElement()) {
				// ���� �ű� �հ谪���� ũ�� �ű� ������ ������Ų��.
				rank.set(sum.size() - 1, rank.get(sum.size() - 1) + 1);
			}
		}
	}

	public static String inputDB(String[] sub_data) {
		// DB�� insert
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
			// �й� ��� sn
			while (true) {
				System.out.println("Ư��:1, ����:2");
				String str_num = sc.nextLine();
				if (check(str_num)) {
					select = Integer.parseInt(str_num);
					break;
				}
				System.out.println("�ٽ��Է�");
			}
			// Ư�� �̶�� ���� �� �Ѱ� �Է�
			if (select == 1) {
				while (true) {
					System.out.print("Ư�� �� �Է�: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						number = Integer.parseInt(str_num);
						break;
					}
					System.out.println("�ٽ��Է�");
				}
				return subshow1("sn", number);

			} else { // �ƴ϶�� min max �Է�
				while (true) {
					System.out.print("min: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						min = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n�ٽ��Է�");
				}
				while (true) {
					System.out.print("max: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						max = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n�ٽ��Է�");
				}
				return subshow2("sn", min, max);
			}
		} else if (choose == 2) {
			// ���� ��� name
			while (true) {
				System.out.print("�̸��Է�: ");
				String str_num = sc.nextLine();
				if (!check(str_num)) {
					name = str_num;
					break;
				}
				System.out.println("\n�ٽ��Է�");
			}
			return subshow3("name", name);

		} else if (choose == 3) {
			// �⼮ ��� attend
			while (true) {
				System.out.println("Ư��:1, ����:2");
				String str_num = sc.nextLine();
				if (check(str_num)) {
					select = Integer.parseInt(str_num);
					break;
				}
				System.out.println("�ٽ��Է�");
			}
			// Ư�� �̶�� ���� �� �Ѱ� �Է�
			if (select == 1) {
				while (true) {
					System.out.print("Ư�� �� �Է�: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						number = Integer.parseInt(str_num);
						break;
					}
					System.out.println("�ٽ��Է�");
				}
				return subshow1("attend", number);

			} else { // �ƴ϶�� min max �Է�
				while (true) {
					System.out.print("min: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						min = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n�ٽ��Է�");
				}
				while (true) {
					System.out.print("max: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						max = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n�ٽ��Է�");
				}
				return subshow2("attend", min, max);
			}
		} else if (choose == 4) {
			// ���� ��� hw
			while (true) {
				System.out.println("Ư��:1, ����:2");
				String str_num = sc.nextLine();
				if (check(str_num)) {
					select = Integer.parseInt(str_num);
					break;
				}
				System.out.println("�ٽ��Է�");
			}
			// Ư�� �̶�� ���� �� �Ѱ� �Է�
			if (select == 1) {
				while (true) {
					System.out.print("Ư�� �� �Է�: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						number = Integer.parseInt(str_num);
						break;
					}
					System.out.println("�ٽ��Է�");
				}
				return subshow1("hw", number);

			} else { // �ƴ϶�� min max �Է�
				while (true) {
					System.out.print("min: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						min = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n�ٽ��Է�");
				}
				while (true) {
					System.out.print("max: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						max = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n�ٽ��Է�");
				}
				return subshow2("hw", min, max);
			}
		} else if (choose == 5) {
			// �߰� ��� mid
			while (true) {
				System.out.println("Ư��:1, ����:2");
				String str_num = sc.nextLine();
				if (check(str_num)) {
					select = Integer.parseInt(str_num);
					break;
				}
				System.out.println("�ٽ��Է�");
			}
			// Ư�� �̶�� ���� �� �Ѱ� �Է�
			if (select == 1) {
				while (true) {
					System.out.print("Ư�� �� �Է�: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						number = Integer.parseInt(str_num);
						break;
					}
					System.out.println("�ٽ��Է�");
				}
				return subshow1("mid", number);

			} else { // �ƴ϶�� min max �Է�
				while (true) {
					System.out.print("min: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						min = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n�ٽ��Է�");
				}
				while (true) {
					System.out.print("max: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						max = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n�ٽ��Է�");
				}
				return subshow2("mid", min, max);
			}
		} else if (choose == 6) {
			// �⸻ ��� fin
			while (true) {
				System.out.println("Ư��:1, ����:2");
				String str_num = sc.nextLine();
				if (check(str_num)) {
					select = Integer.parseInt(str_num);
					break;
				}
				System.out.println("�ٽ��Է�");
			}
			// Ư�� �̶�� ���� �� �Ѱ� �Է�
			if (select == 1) {
				while (true) {
					System.out.print("Ư�� �� �Է�: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						number = Integer.parseInt(str_num);
						break;
					}
					System.out.println("�ٽ��Է�");
				}
				return subshow1("fin", number);

			} else { // �ƴ϶�� min max �Է�
				while (true) {
					System.out.print("min: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						min = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n�ٽ��Է�");
				}
				while (true) {
					System.out.print("max: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						max = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n�ٽ��Է�");
				}
				return subshow2("fin", min, max);
			}
		} else if (choose == 7) {
			// �հ� ��� sum
			while (true) {
				System.out.println("Ư��:1, ����:2");
				String str_num = sc.nextLine();
				if (check(str_num)) {
					select = Integer.parseInt(str_num);
					break;
				}
				System.out.println("�ٽ��Է�");
			}
			// Ư�� �̶�� ���� �� �Ѱ� �Է�
			if (select == 1) {
				while (true) {
					System.out.print("Ư�� �� �Է�: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						number = Integer.parseInt(str_num);
						break;
					}
					System.out.println("�ٽ��Է�");
				}
				return subshow1("sum", number);

			} else { // �ƴ϶�� min max �Է�
				while (true) {
					System.out.print("min: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						min = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n�ٽ��Է�");
				}
				while (true) {
					System.out.print("max: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						max = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n�ٽ��Է�");
				}
				return subshow2("sum", min, max);
			}
		} else if (choose == 8) {
			// ��� ��� rank
			while (true) {
				System.out.println("Ư��:1, ����:2");
				String str_num = sc.nextLine();
				if (check(str_num)) {
					select = Integer.parseInt(str_num);
					break;
				}
				System.out.println("�ٽ��Է�");
			}
			// Ư�� �̶�� ���� �� �Ѱ� �Է�
			if (select == 1) {
				while (true) {
					System.out.print("Ư�� �� �Է�: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						number = Integer.parseInt(str_num);
						break;
					}
					System.out.println("�ٽ��Է�");
				}
				return subshow1("rank", number);

			} else { // �ƴ϶�� min max �Է�
				while (true) {
					System.out.print("min: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						min = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n�ٽ��Է�");
				}
				while (true) {
					System.out.print("max: ");
					String str_num = sc.nextLine();
					if (check(str_num)) {
						max = Integer.parseInt(str_num);
						break;
					}
					System.out.println("\n�ٽ��Է�");
				}
				return subshow2("rank", min, max);
			}
		} else if(choose == 9){
			//���� ��ȯ
			return "SELECT * FROM STUDENT;";
		}else {
			System.out.println("�ٽ� �Է��ϼ���");
			return null;
		}
	}

	public static String subshow1(String column, int select) {
		// show�Լ��� �����Լ�
		return "SELECT * FROM STUDENT WHERE " + column + " = " + select + ";";
	}

	public static String subshow2(String column, int min, int max) {
		// show�Լ��� �����Լ�
		return "SELECT * FROM STUDENT WHERE " + column + " BETWEEN " + min + " AND " + max + ";";
	}

	public static String subshow3(String column, String name) {
		// show�Լ��� �����Լ�
		return "SELECT * FROM STUDENT WHERE " + column + " = '" + name + "';";
	}

	public static String rankupdate(int i) {
		// ��� ������Ʈ
		String sql;
		sql = "UPDATE student SET rank=";
		sql = sql + rank.get(i);
		sql = sql + " WHERE sn= ";
		sql = sql + sc_num.get(i) + ";";
		return sql;

	}

	public static boolean check(String s) {
		// �������� �ƴ��� �������ִ� �Լ�
		try {
			double n = Double.parseDouble(s);
			return true;// �����϶�
		} catch (NumberFormatException e) {
			return false;// �����϶�
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
		String serIp = "127.0.0.1"; // ������
		int port = 8080; // ��Ʈ��ȣ
		int choose;

		String str_num;
		Scanner sc = new Scanner(System.in);
		String data; // ������ ����
		String[] sub_data;// split�� ������ ����
		String sql; // sql�� ����
		String receiveData = ""; // ���� ������ ���� ����

		try {
			socket = new Socket(serIp, port);

			os = socket.getOutputStream(); // ���� ������ ���� outputstream
			osw = new OutputStreamWriter(os);
			pw = new PrintWriter(osw);

			is = socket.getInputStream(); // �����κ��� Data �ޱ�
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);

		} catch (IOException e) {
			System.out.println("���� ���� ����");
		}

		// ���̺� ������ ���̺� ����
		try {
			String table = "CREATE table if not exists STUDENT"
					+ "(sn int,name varchar(20),attend int,hw int,mid int,fin int,sum int,rank int);";
			pw.println(table);
			pw.flush();// ������ �����ϰ� ���۸� ����.
			Thread.sleep(1000); // �ð��� �־ ������Ʈ �Ҽ� �ְ� �����.
			pw.println("ALTER TABLE student convert to charset utf8;");// �ѱ۵� ������ �ְ� �Ѵ�.
			pw.flush();
		} catch (InterruptedException e) {
			System.out.println("���̺� ���� �� ���� ����");
		}

		do {
			while (true) {
				System.out.println("�ű��Է�:1, ���:2, ����:3>>");
				str_num = sc.nextLine();
				if (check(str_num)) {
					choose = Integer.parseInt(str_num);
					break;
				}
				System.out.println("�ٽ��Է�");
			}

			if (choose == 1) {
				System.out.println("1.�ű��Է�");
				System.out.println("�й�, ����, �⼮, ����, �߰�, �⸻ �Է�: ");
				// ������ �Է¹ޱ�
				data = sc.nextLine();
				sub_data = data.split(",");
				// ���� ���ǰ� �ȸ����� ó������
				if (sub_data.length != 6) {
					System.out.println("�ٽ��Է�");
					continue;
				}
				if (!check(sub_data[0])) {
					System.out.println("�ٽ��Է�");
					continue;
				} else if (check(sub_data[1])) {
					System.out.println("�ٽ��Է�");
					continue;
				} else if (!check(sub_data[2])) {
					System.out.println("�ٽ��Է�");
					continue;
				} else if (!check(sub_data[3])) {
					System.out.println("�ٽ��Է�");
					continue;
				} else if (!check(sub_data[4])) {
					System.out.println("�ٽ��Է�");
					continue;
				} else if (!check(sub_data[5])) {
					System.out.println("�ٽ��Է�");
					continue;
				}

				if (inputData(sub_data)) {
					// �����Ͱ� ���������� �ԷµǾ��ٸ�
					// ���� ����
					sql = inputDB(sub_data);
					// ���� �����ϰ� ����
					pw.println(sql);
					pw.flush();
					// ���� ����
					rank();

					// ��� ������Ʈ
					try {
						for (int i = 0; i < rank.size(); i++) {
							sql = rankupdate(i);
							pw.println(sql);
							pw.flush();
							Thread.sleep(500); // �ð��� �־ ������Ʈ �Ҽ� �ְ� �����.
						}
					} catch (InterruptedException e) {
						System.out.println("rankupdate ����");
					}

					// �������� ������ �ޱ�
					try {
						Thread.sleep(20); // �ð��� �־ ������Ʈ �Ҽ� �ְ� �����.
						System.out.println("�Է� ����");
						pw.println("�Է� ����");
						pw.flush();

					} catch (InterruptedException e) {
						System.out.println("������ ���� ����");
					}

				} else {
					// ���� �ƴ϶��
					try {
						Thread.sleep(20); // �ð��� �־ ������Ʈ �Ҽ� �ְ� �����.
						System.out.println("�ߺ� ���� : �Է� ����");
						pw.println("�ߺ� ���� : �Է� ����");
						pw.flush();
					} catch (InterruptedException e) {
						System.out.println("������ ���� ����");
					}
				}
			} else if (choose == 2) {
				System.out.println("2.���");
				while (true) {
					System.out.println("�й�:1, ����:2, �⼮:3, ����:4, �߰�:5,\n�⸻:6, �հ�:7 ,���:8 ,����:9");
					str_num = sc.nextLine();
					if (check(str_num)) {// �ùٸ� �� �Է�
						choose = Integer.parseInt(str_num);
						break;
					}
					System.out.println("�ٽ��Է�");
				}
				try {
					Thread.sleep(20); // �ð��� �־ ������Ʈ �Ҽ� �ְ� �����.
					sql = show(choose); // sql�� �Է�
					pw.println(sql);
					pw.flush();
					Thread.sleep(1000);
					while (br.ready()) { // �غ�Ǹ� ���
						receiveData = br.readLine();
						System.out.println(receiveData);
						Thread.sleep(30);
					}
				} catch (InterruptedException e) {
					System.out.println("������ ���� ����");
				} catch (IOException e) {
					System.out.println("IOException");
				}

			} else if (choose == 3) {
				System.out.println("3.����"); // ������ �����ϱ� ���� 3�� ������
				pw.println(choose);
				pw.close();
				return;
			} else {
				System.out.println("�ٽ� �Է��ϼ���");
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
			System.out.println("close ����");
		}

		return;
	}

}
