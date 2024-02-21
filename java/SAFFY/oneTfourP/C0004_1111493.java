package SAFFY.oneTfourP;

import java.net.*;
import java.util.Arrays;
import java.io.*;

public class C0004_1111493 {

	// 닉네임을 사용자에 맞게 변경해 주세요.
	static final String NICKNAME = "C0004_1111493";
	
	// 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
	static final String HOST = "127.0.0.1";

	// 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
	static final int PORT = 1447;
	static final int CODE_SEND = 9901;
	static final int CODE_REQUEST = 9902;
	static final int SIGNAL_ORDER = 9908;
	static final int SIGNAL_CLOSE = 9909;

	// 게임 환경에 대한 상수입니다.
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

	static double R = 5.73;
	static double p, r;
	
	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		float[][] balls = new float[NUMBER_OF_BALLS][2];
		int order = 0;

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = CODE_SEND + "/" + NICKNAME + "/";
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play!\n--------------------");
			int k = 1;
			while (socket != null) {

				// Receive Data
				bytes = new byte[1024];
				int count_byte = is.read(bytes);
				recv_data = new String(bytes, 0, count_byte, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				// Read Game Data
				String[] split_data = recv_data.split("/");
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Float.parseFloat(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}

				// Check Signal for Player Order or Close Connection
				if (balls[0][0] == SIGNAL_ORDER) {
					order = (int)balls[0][1];
					System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
					continue;
				} else if (balls[0][0] == SIGNAL_CLOSE) {
					break;
				}

				// Show Balls' Position
				for (int i = 0; i < NUMBER_OF_BALLS; i++) {
					System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
				}

				double angle = 0.0;
				double power = 0.0;

				//////////////////////////////
				// 이 위는 일타싸피와 통신하여 데이터를 주고 받기 위해 작성된 부분이므로 수정하면 안됩니다.
				//
				// 모든 수신값은 변수, 배열에서 확인할 수 있습니다.
				//   - order: 1인 경우 선공, 2인 경우 후공을 의미
				//   - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
				//     예) balls[0][0]: 흰 공의 X좌표
				//         balls[0][1]: 흰 공의 Y좌표
				//         balls[1][0]: 1번 공의 X좌표
				//         balls[4][0]: 4번 공의 X좌표
				//         balls[5][0]: 마지막 번호(8번) 공의 X좌표
				
				// 여기서부터 코드를 작성하세요.
				// 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.
				
				/**
				 * 전략
				 * 목적구는 1 -> 3 -> 5 의 순서대로 진행
				 * 1. 목적구에서 가장 가까운 홀을 찾음
				 * 2. 홀, 목적구, 흰공의 x, y 좌표를 이용해 각도 계산
				 * 3. 해당 각도를 흰공의 4분면 에서의 목적구의 위치에 따라 각도 재설정
				 * 4. power, angle 세팅 후 전송
				 */
				
				// 선공일 경우만 고려, 1 -> 3 -> 5 순서
				float whiteBall_x = balls[0][0];
				float whiteBall_y = balls[0][1];
				float targetBall_x;
				float targetBall_y;
				int target = 0;
				if (order == 1) {
					if (balls[1][0] != -1) {
						targetBall_x = balls[1][0];
						targetBall_y = balls[1][1];
						target = 1;
					} else if (balls[3][0] != -1) {
						targetBall_x = balls[3][0];
						targetBall_y = balls[3][1];
						target = 3;
					} else {
						targetBall_x = balls[5][0];
						targetBall_y = balls[5][1];
						target = 5;
					}
				}
				else {
					if (balls[2][0] != -1) {
						targetBall_x = balls[2][0];
						targetBall_y = balls[2][1];
						target = 2;
					} else if (balls[4][0] != -1) {
						targetBall_x = balls[4][0];
						targetBall_y = balls[4][1];
						target = 4;
					} else {
						targetBall_x = balls[5][0];
						targetBall_y = balls[5][1];
						target = 5;
					}
				}
				
				// 목적구의 가장 가까운 홀을 찾아 각도와 세기 정해줌
				setXY(balls, target, closeHole(balls, target), whiteBall_x, whiteBall_y);
				
				power = 80;
				angle = r;
				System.out.println("power: " + power + ", angle: " + angle);

				// 주어진 데이터(공의 좌표)를 활용하여 두 개의 값을 최종 결정하고 나면,
				// 나머지 코드에서 일타싸피로 값을 보내 자동으로 플레이를 진행하게 합니다.
				//   - angle: 흰 공을 때려서 보낼 방향(각도)
				//   - power: 흰 공을 때릴 힘의 세기
				// 
				// 이 때 주의할 점은 power는 100을 초과할 수 없으며,
				// power = 0인 경우 힘이 제로(0)이므로 아무런 반응이 나타나지 않습니다.
				//
				// 아래는 일타싸피와 통신하는 나머지 부분이므로 수정하면 안됩니다.
				//////////////////////////////

				String merged_data = angle + "/" + power + "/";
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}

			os.close();
			is.close();
			socket.close();
			System.out.println("Connection Closed.\n--------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void setXY(float[][] balls, int ball, int hole, float wX, float wY) {
		System.out.println("closeHole: " + hole);
		double a1 = Math.sqrt(Math.pow(HOLES[hole][0] - balls[ball][0], 2) + Math.pow(HOLES[hole][1] - balls[ball][1], 2));
		double a2 = a1 + 2*R;
		double b2 = a2 * Math.abs(HOLES[hole][0] - balls[ball][0]) / a1;
		double c2 = a2 * Math.abs(HOLES[hole][1] - balls[ball][1]) / a1;
		double x, y;
		if (HOLES[hole][0] <= balls[ball][0] && HOLES[hole][1] <= balls[ball][1]) {
			x = HOLES[hole][0] + b2;
			y = HOLES[hole][1] + c2;
		}
		else if (HOLES[hole][0] <= balls[ball][0] && HOLES[hole][1] > balls[ball][1]) {
			x = HOLES[hole][0] + b2;
			y = HOLES[hole][1] - c2;
		}
		else if (HOLES[hole][0] > balls[ball][0] && HOLES[hole][1] > balls[ball][1]) {
			x = HOLES[hole][0] - b2;
			y = HOLES[hole][1] - c2;
		}
		else {
			x = HOLES[hole][0] - b2;
			y = HOLES[hole][1] + c2;
		}
		System.out.println(x + ", " + y);
		r = Math.toDegrees(-Math.atan((x-wX)/(y-wY)));
	}
	
	// power, angle 세팅 -> static 변수에 넣기 (power = p, angle = r)
	static void makeRadian(float[][] balls, int ball, int hole) {
		//System.out.println(ball + ", " + hole);
		double x = Math.abs(balls[0][0] - HOLES[hole][0]);
		double y = Math.abs(balls[0][1] - HOLES[hole][1]);
		double a = Math.sqrt(x*x + y*y);
		double b = Math.sqrt(Math.pow(balls[ball][0] - HOLES[hole][0], 2) + Math.pow(balls[ball][1] - HOLES[hole][1], 2));
		double c = Math.sqrt(Math.pow(balls[0][0] - balls[ball][0], 2) + Math.pow(balls[0][1] - balls[ball][1], 2));
		double ga = Math.atan(x/y);
		double na = Math.acos((a*a + b*b - c*c)/(2*a*b) > 1 ? 1 : (a*a + b*b - c*c)/(2*a*b));
		double d = Math.sqrt(a*a + Math.pow(b+2*R, 2) - 2 * a * (b + 2 * R) * Math.cos(na));
		double da = Math.acos((a*a + d*d - Math.pow(b+2*R, 2))/(2*a*d));
		p = d;
		r = Math.toDegrees(ga+da);

	}
	
	// 목적구와 가장 가까운 Hole의 인덱스 반환 
	static int closeHole(float[][] balls, int ball) {
		int hole = 0;
		double distance = Integer.MAX_VALUE;
		for (int i = 0; i < 6; i++) {
			if ((Math.abs(balls[ball][0] - HOLES[i][0]) + Math.abs(balls[ball][1] - HOLES[i][1]) < distance)) {
				distance = (Math.abs(balls[ball][0] - HOLES[i][0]) + Math.abs(balls[ball][1] - HOLES[i][1]));
				hole = i;
			}
		}
		return hole;
	}
}
