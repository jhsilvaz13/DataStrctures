/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linearStructures;

/**
 *
 * @author jhonz
 */
public class IntegerContainer extends LinkedList<Integer> {

    private Integer operaciones[];
    private Integer parametros[];
    LinkedList<Integer> copia = new LinkedList<Integer>();
    int print=0;

    public IntegerContainer(Integer operaciones[], Integer parametros[]) {
        super();
        this.operaciones = operaciones;
        this.parametros = parametros;
    }

    //Añadir elemento newnode
    public void add(Node<Integer> newNode) {
        copiarContainer();
        this.pushBack(newNode);
    }

    //eliminar los k ultimos enteros
    public void delete(int k) {
        copiarContainer();
        for (int i = 0; i < k; i++) {
            this.popBack();
        }
    }

    //imprimir el entero k-esimo
    public void print(int k) {
        k -= 1;
        Node<Integer> iterator = this.getBeginNode();
        int count = 0;
        while (count < k) {
            iterator = iterator.nextNode;
            count++;
        }
        if(print==1){
            System.out.printf("%s",iterator.data);
        }else{
            System.out.printf("\n%s",iterator.data);
        }
    }

    public void undo() {
        if (copia.getBeginNode() != null) {
           LinkedList<Integer> aux=new LinkedList<Integer>();
           Node<Integer> iterator = copia.getBeginNode();
           aux.pushBack(new Node<Integer>(iterator.data));
            while (iterator.nextNode != null) {
                iterator = iterator.nextNode;
                aux.pushBack(new Node<Integer>(iterator.data));
            }
           copiarContainer();
           //this.beginNode=this.lastNode=new Node<Integer>(aux.getBeginNode().data);
           Node<Integer> iterator2= aux.getBeginNode();
            while (iterator2.nextNode != null) {
                iterator2 = iterator2.nextNode;
                this.pushBack(new Node<Integer>(iterator2.data));
            }
        }

    }

    public void redo() {
        undo();
    }

    public void copiarContainer() {
        if (this.getBeginNode() != null) {
            copia = new LinkedList<Integer>();;
            Node<Integer> iterator = this.getBeginNode();
            copia.pushBack(new Node<Integer>(iterator.data));
            while (iterator.nextNode != null) {
                iterator = iterator.nextNode;
                copia.pushBack(new Node<Integer>(iterator.data));
            }
        }
    }

    public void solucion() {
        for (int i = 0; i < operaciones.length; i++) {
            if (operaciones[i].equals(1)) {
                add(new Node<Integer>(parametros[i]));
            } else if (operaciones[i].equals(2)) {
                delete((int) parametros[i]);
            } else if (operaciones[i].equals(3)) {
                print+=1;
                print((int) parametros[i]);
            } else if (operaciones[i].equals(4)) {
                undo();
            } else {
                redo();
            }
            /*this.print();
            if(copia.getBeginNode()!=null){
                System.out.print("Copia: ");
                copia.print();
            }*/

        }
    }
}
