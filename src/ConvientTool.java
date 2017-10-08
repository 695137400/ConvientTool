import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class ConvientTool{
    private static int fW = 250;
    private static int fh = 300;
    static boolean isDragged = false;
    static Point loc = null;
    static Point tmp = null;

    private static JPanel contentPane;
    public static void main(String args[]) {
        JFrame f = new JFrame("便签");//实例化窗体对象
        f.setBackground(Color.WHITE);//设置窗体的背景颜色
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTextArea txaDisplay = new JTextArea();
        txaDisplay.setLineWrap(true);
        txaDisplay.setWrapStyleWord(true);
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        f.setContentPane(contentPane);
        //给面板添加边框，边框添加 放大缩小功能
        contentPane.setBorder(new Border(Color.WHITE, 2, f));
        JScrollPane scroll = new JScrollPane(txaDisplay);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setRowHeaderView(new LineNumberHeaderView());
        txaDisplay.setBackground(new Color(255, 255, 128));
        contentPane.add(scroll, BorderLayout.CENTER);
        f.setBounds(fW, fh, fW, fh);
        f.setAlwaysOnTop(true);
        f.setUndecorated(true);
        scroll.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent e) {
                if (isDragged) {
                    loc = new Point(f.getLocation().x + e.getX() - tmp.x, f.getLocation().y + e.getY() - tmp.y);
                    f.setLocation(loc);
                }
            }
        });
        txaDisplay.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("鼠标进入");
                int x = f.getX();
                int y = f.getY();
                System.out.println("x=" + x);
                System.out.println("y=" + y);
                Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
                int width = (int) screensize.getWidth();
                int height = (int) screensize.getHeight();
                System.out.println("width=" + width);
                System.out.println("height=" + height);
                System.out.println("fW=" + fW);
                System.out.println("fh=" + fh);
                System.out.println("-----" + f.getComponent(0).getWidth());
                /*if (x == 0 || y == 0) {
                    f.setBounds(width - (x - 100), y, 250, 300);
                }*/
                if (x < 20 || width - x < 20) {
                    if (x < 20) {
                        f.setBounds(0, y, fW, fh);
                    }
                }
                if (y < 20 || height - y < 20) {
                    if (y < 20) {
                        f.setBounds(x, 0, fW, fh);
                    }
                }

            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("鼠标移除");
                int x = f.getX();
                int y = f.getY();
                System.out.println("x=" + x);
                System.out.println("y=" + y);
                Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
                int width = (int) screensize.getWidth();
                int height = (int) screensize.getHeight();
                System.out.println("width=" + width);
                System.out.println("height=" + height);
                System.out.println("fW=" + fW);
                System.out.println("fh=" + fh);
                System.out.println("-----" + f.getComponent(0).getWidth());
                /*if (x == 0 || y == 0) {
                    f.setBounds(width - (x - 100), y, 250, 300);
                }*/
                if (x < 20 || width - x < 20) {
                    if (x < 20) {
                        f.setBounds(fW - fW * 2 + 19, y, fW, fh);
                    }
                    if (width - x < 20) {
                        f.setSize(width + x, y);
                    }
                }
                if (y < 20 || height - y < 20) {
                    if (y < 20) {
                        f.setBounds(x, fh - fh * 2 + 19, fW, fh);
                    }
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(1);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                tmp = new Point(e.getX(), e.getY());
                isDragged = true;
                f.setCursor(new Cursor(Cursor.MOVE_CURSOR));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isDragged = false;
                f.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        scroll.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("鼠标进入");
                int x = f.getX();
                int y = f.getY();
                System.out.println("x=" + x);
                System.out.println("y=" + y);
                Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
                int width = (int) screensize.getWidth();
                int height = (int) screensize.getHeight();
                System.out.println("width=" + width);
                System.out.println("height=" + height);
                System.out.println("fW=" + fW);
                System.out.println("fh=" + fh);
                System.out.println("-----" + f.getComponent(0).getWidth());
                /*if (x == 0 || y == 0) {
                    f.setBounds(width - (x - 100), y, 250, 300);
                }*/
                if (x < 20 || width - x < 20) {
                    if (x < 20) {
                        f.setBounds(0, y, fW, fh);
                    }
                }
                if (y < 20 || height - y < 20) {
                    if (y < 20) {
                        f.setBounds(x, 0, fW, fh);
                    }
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("鼠标移除");
                int x = f.getX();
                int y = f.getY();
                System.out.println("x=" + x);
                System.out.println("y=" + y);
                Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
                int width = (int) screensize.getWidth();
                int height = (int) screensize.getHeight();
                System.out.println("width=" + width);
                System.out.println("height=" + height);
                System.out.println("fW=" + fW);
                System.out.println("fh=" + fh);
                System.out.println("-----" + f.getComponent(0).getWidth());
                /*if (x == 0 || y == 0) {
                    f.setBounds(width - (x - 100), y, 250, 300);
                }*/
                if (x < 20 || width - x < 20) {
                    if (x < 20) {
                        f.setBounds(fW - fW * 2 + 19, y, fW, fh);
                    }
                    if (width - x < 20) {
                        f.setSize(width + x, y);
                    }
                }
                if (y < 20 || height - y < 20) {
                    if (y < 20) {
                        f.setBounds(x, fh - fh * 2 + 19, fW, fh);
                    }
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(1);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                tmp = new Point(e.getX(), e.getY());
                isDragged = true;
                f.setCursor(new Cursor(Cursor.MOVE_CURSOR));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isDragged = false;
                f.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        f.setVisible(true);//让组建显示
    }
}
//主要代码
class Border extends LineBorder implements MouseInputListener {
    private static final long serialVersionUID = 1L;
    private static int fW = 250;
    private static int fh = 300;
    private JFrame frame;
    private int delta;

    private Point sp;
    private Point cp;
    private int width;
    private int height;

    private boolean top, bottom, left, right, topLeft, topRight,
            bottomLeft, bottomRight;

    public Border(Color color, int delta, JFrame frame) {
        super(color, delta);
        this.delta = delta;
        this.frame = frame;

        this.frame.addMouseMotionListener(this);
        this.frame.addMouseListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point dp = e.getLocationOnScreen();
        // 拖动时的组件原点
        int ox = dp.x - cp.x;
        int oy = dp.y - cp.y;

        // 静止的 原点
        int x = sp.x - cp.x;
        int y = sp.y - cp.y;

        int h = height;
        int w = width;

        if (top) {
            ox = x;
            h = height + (-dp.y + sp.y);
        } else if (bottom) {
            oy = y;
            ox = x;
            h = height + (dp.y - sp.y);
        } else if (left) {
            oy = y;
            w = width + (-dp.x + sp.x);
        } else if (right) {
            oy = y;
            ox = x;
            w = width + (dp.x - sp.x);
        } else if (topLeft) {
            h = height + (-dp.y + sp.y);
            w = width + (-dp.x + sp.x);
        } else if (topRight) {
            ox = x;
            h = height + (-dp.y + sp.y);
            w = width + (dp.x - sp.x);
        } else if (bottomLeft) {
            oy = y;
            h = height + (-dp.y + sp.y);
            w = width + (dp.x - sp.x);
        } else if (bottomRight) {
            ox = x;
            oy = y;
            h = height + (dp.y - sp.y);
            w = width + (+dp.x - sp.x);
        }
        frame.setLocation(ox, oy);
        frame.setSize(w, h);
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
        sp = arg0.getLocationOnScreen();
        cp = arg0.getPoint();
        width = frame.getWidth();
        height = frame.getHeight();

        top = cp.x > delta && cp.x < width - delta && cp.y <= delta;
        bottom = cp.x > delta && cp.x < width - delta
                && cp.y >= height - delta;
        left = cp.x <= delta && cp.y > delta && cp.y < height - delta;
        right = cp.x >= width - delta && cp.y > delta
                && cp.y < height - delta;

        topLeft = cp.x <= delta && cp.y <= delta;
        topRight = cp.x >= width - delta && cp.y <= delta;

        bottomLeft = cp.x <= delta && cp.y >= height - delta;
        bottomRight = cp.x >= width - delta && cp.y >= height - delta;

        if (top) {
            frame.setCursor(Cursor
                    .getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
            return;
        } else if (bottom) {
            frame.setCursor(Cursor
                    .getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
        } else if (left) {
            frame.setCursor(Cursor
                    .getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
        } else if (right) {
            frame.setCursor(Cursor
                    .getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
        } else if (topLeft) {
            frame.setCursor(Cursor
                    .getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
        } else if (topRight) {
            frame.setCursor(Cursor
                    .getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
        } else if (bottomLeft) {
            frame.setCursor(Cursor
                    .getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
        } else if (bottomRight) {
            frame.setCursor(Cursor
                    .getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
        }
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        System.out.println("鼠标进入");
        int x = frame.getX();
        int y = frame.getY();
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screensize.getWidth();
        int height = (int) screensize.getHeight();
        System.out.println("width=" + width);
        System.out.println("height=" + height);
        System.out.println("fW=" + fW);
        System.out.println("fh=" + fh);
        System.out.println("-----" + frame.getComponent(0).getWidth());
                /*if (x == 0 || y == 0) {
                    f.setBounds(width - (x - 100), y, 250, 300);
                }*/
        if (x < 20 || width - x < 20) {
            if (x < 20) {
                frame.setBounds(0, y, fW, fh);
            }
        }
        if (y < 20 || height - y < 20) {
            if (y < 20) {
                frame.setBounds(x, 0, fW, fh);
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        System.out.println("鼠标移除");
        int x = frame.getX();
        int y = frame.getY();
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screensize.getWidth();
        int height = (int) screensize.getHeight();
        System.out.println("width=" + width);
        System.out.println("height=" + height);
        System.out.println("fW=" + fW);
        System.out.println("fh=" + fh);
        System.out.println("-----" + frame.getComponent(0).getWidth());
                /*if (x == 0 || y == 0) {
                    f.setBounds(width - (x - 100), y, 250, 300);
                }*/
        if (x < 20 || width - x < 20) {
            if (x < 20) {
                frame.setBounds(fW - fW * 2 + 19, y, fW, fh);
            }
            if (width - x < 20) {
                frame.setSize(width + x, y);
            }
        }
        if (y < 20 || height - y < 20) {
            if (y < 20) {
                frame.setBounds(x, fh - fh * 2 + 19, fW, fh);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }

}

class LineNumberHeaderView extends javax.swing.JComponent {

    /**
     * JAVA TextArea行数显示插件
     */
    private static final long serialVersionUID = 1L;
    private final  Font DEFAULT_FONT = new Font(Font.MONOSPACED, Font.PLAIN, 11);
    public final Color DEFAULT_BACKGROUD = new Color(228, 228, 228);
    public final Color DEFAULT_FOREGROUD = Color.BLACK;
    public final int nHEIGHT = Integer.MAX_VALUE - 1000000;
    public final int MARGIN = 5;
    private int lineHeight;
    private int fontLineHeight;
    private int currentRowWidth;
    private FontMetrics fontMetrics;

    public LineNumberHeaderView() {
        setFont(DEFAULT_FONT);
        setForeground(DEFAULT_FOREGROUD);
        setBackground(DEFAULT_BACKGROUD);
        setPreferredSize(9999);
    }

    public void setPreferredSize(int row) {
        int width = fontMetrics.stringWidth(String.valueOf(row));
        if (currentRowWidth < width) {
            currentRowWidth = width;
            setPreferredSize(new Dimension(2 * MARGIN + width + 1, nHEIGHT));
        }
    }

    @Override
    public void setFont(Font font) {
        super.setFont(font);
        fontMetrics = getFontMetrics(getFont());
        fontLineHeight = fontMetrics.getHeight();
    }

    public int getLineHeight() {
        if (lineHeight == 0) {
            return fontLineHeight;
        }
        return lineHeight;
    }

    public void setLineHeight(int lineHeight) {
        if (lineHeight > 0) {
            this.lineHeight = lineHeight;
        }
    }

    public int getStartOffset() {
        return 4;
    }

    @Override
    protected void paintComponent(Graphics g) {
        int nlineHeight = getLineHeight();
        int startOffset = getStartOffset();
        Rectangle drawHere = g.getClipBounds();
        g.setColor(getBackground());
        g.fillRect(drawHere.x, drawHere.y, drawHere.width, drawHere.height);
        g.setColor(getForeground());
        int startLineNum = (drawHere.y / nlineHeight) + 1;
        int endLineNum = startLineNum + (drawHere.height / nlineHeight);
        int start = (drawHere.y / nlineHeight) * nlineHeight + nlineHeight - startOffset;
        for (int i = startLineNum; i <= endLineNum; ++i) {
            String lineNum = String.valueOf(i);
            int width = fontMetrics.stringWidth(lineNum);
            g.drawString(lineNum + " ", MARGIN + currentRowWidth - width - 1, start);
            start += nlineHeight;
        }
        setPreferredSize(endLineNum);
    }
}