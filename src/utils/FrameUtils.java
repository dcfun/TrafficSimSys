package utils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by uu789 on 2015/10/24.
 */
public class FrameUtils {

    //使窗体居中
    public static void setFrameCenter(JFrame frame){

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();

        int x = ((screen.width - frame.getWidth()) / 2);
        int y = ((screen.height - frame.getHeight()) / 2) - 10;
        frame.setLocation(x, y);
    }
}
