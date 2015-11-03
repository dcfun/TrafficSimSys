package control;

import dto.MapArray;
import dto.SysDto;
import service.SysService;
import ui.FrameMain;
import ui.PanelMain;

/**
 * Created by uu789 on 2015/10/25.
 */
public class SysControl {
	private MapArray map = new MapArray();
	private SysDto dto = new SysDto();
	private SysService service = new SysService();
	private PanelMain panel = new PanelMain(dto, this);
	private FrameMain frame = new FrameMain(this.panel);

	public SysControl() {
		this.service.setDto(dto);
		this.service.setMap(map);
		
		this.go();
	}

	public void go() {
		// 仿真系统**线程**
		Thread SysThread = new Thread(new Runnable() {

			public void run() {
				//初始化地图接点
				service.initMapNodes();
				
				// 初始化小车列表
				service.initCarList();
				
				// 刷新界面的**线程**
				Thread PanelThread = new Thread(panel);

				// 车的**线程**
				Thread CarThread = new Thread() {
					@Override
					public void run() {
						while (true) {
							service.carRun();
							try {
								Thread.sleep(5);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				};
				
				//启动紫禁城
				PanelThread.start();
				CarThread.start();

			}

		});

		SysThread.start();

	}

}
