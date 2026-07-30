import javax.swing.*
import javax.swing.event.ListSelectionEvent
import javax.swing.event.ListSelectionListener
import java.awt.*


fun crearListaCompras() {
    val frame = JFrame("Ejercicio 4: Lista de Compras").apply {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(350, 250)
        setLocationRelativeTo(null)
    }

    // CONCEPTO 9: Modelos de Datos (DefaultListModel)
    // En Swing, los componentes visuales (JList) no guardan los datos directamente.
    // Usan un "Modelo" que actúa como intermediario entre los datos y la vista.
    val modeloLista = DefaultListModel<String>()
    val listaCompras = JList(modeloLista)

    val comboProductos = JComboBox(arrayOf("Manzanas", "Pan", "Leche", "Huevos", "Café"))
    val btnAgregar = JButton("Agregar")
    val btnEliminar = JButton("Eliminar Seleccionado")

    btnAgregar.addActionListener {
        val productoSeleccionado = comboProductos.selectedItem as String

        // Evitar duplicados (Lógica de negocio)
        if (!modeloLista.contains(productoSeleccionado)) {
            modeloLista.addElement(productoSeleccionado)
        } else {
            JOptionPane.showMessageDialog(frame, "El producto ya está en la lista.")
        }
    }

    btnEliminar.addActionListener {
        // CONCEPTO 10: Interacción con selecciones
        // getSelectedIndex devuelve -1 si no hay nada seleccionado.
        val indice = listaCompras.selectedIndex
        if (indice != -1) {
            modeloLista.remove(indice)
        }
    }

    // CONCEPTO 11: ListSelectionListener
    // Escucha los cambios en la selección de la lista.
    listaCompras.addListSelectionListener { e: ListSelectionEvent ->
        // valueIsAdjusting evita que el evento se dispare múltiples veces mientras el usuario hace clic.
        if (!e.valueIsAdjusting) {
            val seleccionado = listaCompras.selectedValue
            frame.title = if (seleccionado != null) "Seleccionado: $seleccionado" else "Lista de Compras"
        }
    }

    // Layout para organizar los botones y la lista
    val panelSuperior = JPanel()
    panelSuperior.add(comboProductos)
    panelSuperior.add(btnAgregar)
    panelSuperior.add(btnEliminar)

    frame.add(panelSuperior, BorderLayout.NORTH)
    frame.add(JScrollPane(listaCompras), BorderLayout.CENTER) // JScrollPane permite hacer scroll si la lista crece

    frame.isVisible = true
}

fun main() {
    SwingUtilities.invokeLater { crearListaCompras() }
}
