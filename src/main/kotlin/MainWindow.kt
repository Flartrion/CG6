import java.awt.BorderLayout
import java.awt.GridLayout
import javax.swing.*

class MainWindow : JFrame() {
    private val icoSphere = IcoSphere()

    init {
        val inputPanel = JPanel()
        inputPanel.layout = BorderLayout()

        val parametersPanel = JPanel()
        parametersPanel.layout = GridLayout(5, 3)

        val lightPositionX = JTextField("200")
        val lightPositionY = JTextField("200")
        val lightPositionZ = JTextField("200")
        val lightPositionButton = JButton("Переместить")
        lightPositionButton.addActionListener {
            icoSphere.lightPosition =
                Vertex(lightPositionX.text.toDouble(), lightPositionY.text.toDouble(), lightPositionZ.text.toDouble())
            repaint()
        }

        parametersPanel.add(JLabel("Позиция источника света", 0))
        parametersPanel.add(JLabel(" "))
        parametersPanel.add(JLabel("X: "))
        parametersPanel.add(lightPositionX)
        parametersPanel.add(JLabel("Y: "))
        parametersPanel.add(lightPositionY)
        parametersPanel.add(JLabel("Z: "))
        parametersPanel.add(lightPositionZ)
        parametersPanel.add(lightPositionButton)
        parametersPanel.add(JLabel(" "))

        val rotationsPanel = JPanel()
        rotationsPanel.layout = GridLayout(2, 3)

        val rotationX = JTextField("5")
        val rotationY = JTextField("5")
        val rotationXButton = JButton("Повернуть")
        val rotationYButton = JButton("Повернуть")

        rotationXButton.addActionListener {
            icoSphere.rotateOnX(rotationX.text.toDouble())
            repaint()
        }
        rotationYButton.addActionListener {
            icoSphere.rotateOnY(rotationY.text.toDouble())
            repaint()
        }

        rotationsPanel.add(JLabel("X: "))
        rotationsPanel.add(rotationX)
        rotationsPanel.add(rotationXButton)
        rotationsPanel.add(JLabel("Y: "))
        rotationsPanel.add(rotationY)
        rotationsPanel.add(rotationYButton)

        val inputZone = JPanel()
        inputZone.layout = GridLayout(1, 2)
        inputZone.add(parametersPanel)
        inputZone.add(rotationsPanel)

        val topLabels = JPanel()
        topLabels.layout = GridLayout(1, 2)
        topLabels.add(JLabel("Параметры", 0))
        topLabels.add(JLabel("Повороты", 0))

        inputPanel.add(topLabels, BorderLayout.NORTH)
        inputPanel.add(inputZone, BorderLayout.SOUTH)

        this.add(inputPanel, BorderLayout.NORTH)
        this.defaultCloseOperation = EXIT_ON_CLOSE
        this.title = "Smooth criminal"
        this.isResizable = true
        this.add(icoSphere, BorderLayout.CENTER)
        this.pack()
        this.setLocationRelativeTo(null)
        this.isVisible = true
    }
}