package `interface`

import server.ServerConnection
import java.awt.BorderLayout
import java.awt.Component
import java.awt.Dimension
import java.awt.GridLayout
import java.awt.event.ActionListener
import java.net.Socket
import java.sql.Connection
import javax.swing.*
import javax.swing.JOptionPane.*

class MainScreen : JFrame() {
    init {
        contentPane.layout = BoxLayout(contentPane, BoxLayout.Y_AXIS)


        var joinServerButton = JButton("Подключиться к серверу").apply {
            alignmentX = Component.CENTER_ALIGNMENT
            preferredSize = Dimension(200, 50)
        }

        var createHostButton = JButton("Стать хостом").apply {
            alignmentX = Component.CENTER_ALIGNMENT
            preferredSize = Dimension(200, 50)
        }

        var connectionHostNameField = JTextField()
        var connectionPortField = JTextField()

        var serverJoinDialog = JPanel().apply {
            layout = BoxLayout(this, BoxLayout.Y_AXIS)
            add(JLabel("Aдрес сервера"))
            add(connectionHostNameField)
            add(JLabel("Порт"))
            add(connectionPortField)
        }

        joinServerButton.addActionListener {
            var dialogResult = showConfirmDialog(null, serverJoinDialog,
                    "Подключение к серверу", JOptionPane.OK_CANCEL_OPTION)
            if (dialogResult == JOptionPane.OK_OPTION) {
                var connection = ServerConnection(Socket(connectionHostNameField.text, connectionPortField.text.toInt()))
            }
        }

        add(Box.createVerticalGlue())
        add(joinServerButton)
        add(createHostButton)
        add(Box.createVerticalGlue())

        contentPane.preferredSize = Dimension(600, 600)

        pack()
        setLocationRelativeTo(null);
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = true
        isVisible = true
    }
}