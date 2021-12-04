/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linearStructures;

import java.util.Arrays;
import java.util.Scanner;
import linearStructures.problemaEnvios.*;

/**
 *
 * @author jhonz
 */
public class main {

    private static final Scanner IN = new Scanner(System.in);

    public static void main(String[] args) {
        punto2Parcial();
    }

    public static void punto2Parcial() {
        double xCiudad, yCiudad; 
        int cRegiones, nPaquetes, mMontones;

        xCiudad = IN.nextInt();
        yCiudad = IN.nextInt();
        cRegiones = IN.nextInt();//Raiz entera
        nPaquetes = IN.nextInt();
        mMontones = IN.nextInt();

        int a = (int) Math.sqrt(cRegiones);
        int b = (int) Math.sqrt(cRegiones);
        double xRegion = (xCiudad / a);//(2000,1000)
        while (a * b != cRegiones) {
            b += 1;
        }
        double yRegion = (yCiudad / b);
        //System.out.println("xReg: "+xRegion+" yRegion: "+yRegion);

        LinkedList<Monton> bodega = hacerMontones(mMontones);
        LinkedList<Camion> cargo = crearCamiones(xCiudad, yCiudad, xRegion, yRegion);

        Node<Monton> iteratorMonto = bodega.getBeginNode();
        //Recorrer los montos y agregar los paquetes a los camiones de acuerdo a su zona de distribucion
        while (iteratorMonto != null) {
            while (iteratorMonto.data.getPilasPaquetes().isEmpty() != true) {
                Node<Paquete> paqueteActual = iteratorMonto.data.getPilasPaquetes().peek();
                Node<Camion> camionIterator = cargo.getBeginNode();
                while (camionIterator != null) {
                    if (paqueteActual.data.getX() <= camionIterator.data.getxRegion() && paqueteActual.data.getY() <= camionIterator.data.getyRegion()) {
                        camionIterator.data.encolarPaquete(paqueteActual.data);
                        break;
                    }
                    camionIterator = camionIterator.nextNode;
                }
            }
            iteratorMonto = iteratorMonto.nextNode;
        }

        Node<Camion> camionIterator = cargo.getBeginNode();
        while (camionIterator != null) {
            Queue<Paquete> aux = camionIterator.data.getColaPaquetes();
            Node<Paquete> iNode = aux.getBeginNode();
            Node<Paquete> jNode;
            while (iNode != null) {
                jNode = aux.getBeginNode();
                while (jNode.nextNode != null) {
                    if (distanciaManhattan(jNode.data, xRegion, yRegion) > distanciaManhattan(jNode.nextNode.data, xRegion, yRegion)) {
                        Paquete temp = jNode.data;
                        jNode.data = jNode.nextNode.data;
                        jNode.nextNode.data = temp;
                    }
                    jNode = jNode.nextNode;
                }
                iNode = iNode.nextNode;
            }
            camionIterator = camionIterator.nextNode;
        }

        camionIterator = cargo.getBeginNode();
        int numCamion = 1;
        while (camionIterator != null) {
            System.out.print(numCamion);
            Queue<Paquete> aux = camionIterator.data.getColaPaquetes();
            Node<Paquete> it = aux.getBeginNode();
            while (it != null) {
                System.out.print(" " + it.data.getSerial());
                it = it.nextNode;
            }
            camionIterator = camionIterator.nextNode;
            if (numCamion != cRegiones) {
                System.out.println();
            }
            numCamion += 1;
        }

    }

    //Leer y crear los montones de paquetes en la bodega
    public static LinkedList<Monton> hacerMontones(int mMontones) {
        LinkedList<Monton> bodega = new LinkedList<Monton>();
        int read = 0;
        while (read <= mMontones) {
            String[] linea = IN.nextLine().split(" ");
            Monton a = new Monton();
            for (int i = 0; i < linea.length - 1; i += 3) {
                Paquete p = new Paquete(Integer.valueOf(linea[i]), Integer.valueOf(linea[i + 1]), Integer.valueOf(linea[i + 2]));
                a.addPaquete(p);
                //System.out.println(p.getSerial());
            }
            bodega.pushBack(new Node<Monton>(a));
            read++;
        }

        return bodega;
    }

    //Crear los camiones necesarios
    public static LinkedList<Camion> crearCamiones(double xCiudad, double yCiudad, double xRegion, double yRegion) {
        LinkedList<Camion> cargo = new LinkedList<Camion>();
        double xAux = xRegion;
        double yAux = yRegion;
        while (yAux <= yCiudad) {
            while (xAux <= xCiudad) {
                Camion c = new Camion(xAux, yAux);
                cargo.pushBack(new Node<Camion>(c));
                xAux += xRegion;
            }
            xAux = xRegion;
            yAux += yRegion;
        }
        /*Node<Camion> it = cargo.getBeginNode();
        while (it != null) {
            System.out.println(it.data.getxRegion() + "," + it.data.getyRegion());
            it = it.nextNode;
        }*/
        return cargo;
    }

    public static double distanciaManhattan(Paquete paq, double xRegion, double yRegion) {//2000,//1000
        //Coordenadas del paquete en el primer cuadrante
        /*System.out.println("xP: " + paq.getX()+ " yP: " + paq.getY());
        System.out.println("xRegion:" +xRegion+" yReg: "+yRegion);*/
        int x =(int) (paq.getX() - (xRegion * ( (int)(paq.getX() / xRegion))));
        int y = (int)(paq.getY() - (yRegion * ( (int)(paq.getY() / yRegion))));
        /*System.out.println("x: " + x + " y: " + y);*/
        if (y % 2 == 0) {
            /*System.out.println("Dist: " +((xRegion * y) + x + y));*/
            return (xRegion * y) + x + y;
        } else {
            /*System.out.println("Dist: " +((xRegion * y) + (xRegion-x) + y));*/
            return (xRegion * y) + (xRegion - x) + y;
        }

    }

    public static void circular() {
        CircularDoubleLinkedList<Integer> a = new CircularDoubleLinkedList<Integer>();
        a.pushBack(new Node<Integer>(10));
        a.pushBack(new Node<Integer>(11));
        a.pushBack(new Node<Integer>(12));
        a.pushBack(new Node<Integer>(13));
        a.print();

    }

    public static void punto1Parcial() {
        int t = IN.nextInt();
        for (int i = 0; i < t; i++) {
            int mayor = 0;
            boolean impr = false;
            int numJugador = 1;
            int tamañoMazo = IN.nextInt();
            int numeroJugadores = IN.nextInt();
            LinkedList<Integer> mazo = new LinkedList<Integer>();
            CircularDoubleLinkedList<Integer> jugadores = new CircularDoubleLinkedList<Integer>();

            for (int j = 0; j < tamañoMazo; j++) {
                mazo.pushBack(new Node<Integer>(IN.nextInt()));
            }
            for (int j = 0; j < numeroJugadores; j++) {
                jugadores.pushBack(new Node<Integer>(0));
            }
            //Sumar a los jugadores las cartas mayores 
            Node<Integer> iterator = jugadores.beginNode;
            while (mazo.isEmpty() == false) {
                if (mazo.getBeginNode().data >= mazo.getLastNode().data) {
                    iterator.data += mazo.getBeginNode().data;
                    mazo.popFront();
                } else {
                    iterator.data += mazo.getLastNode().data;
                    mazo.popBack();
                }
                iterator = iterator.nextNode;
            }
            //Encontrar el mayor
            iterator = jugadores.beginNode;
            if (iterator.data > mayor) {
                mayor = iterator.data;
            }
            while (iterator.nextNode != jugadores.beginNode) {
                iterator = iterator.nextNode;
                if (iterator.data > mayor) {
                    mayor = iterator.data;
                }
            }
            //Imprimir los ganadaores
            System.out.printf("Caso #%d:\n", i + 1);
            iterator = jugadores.beginNode;
            if (iterator.data == mayor) {
                System.out.printf("%d", numJugador);
                impr = true;
            }
            numJugador += 1;
            while (iterator.nextNode != jugadores.beginNode) {
                if (!impr) {
                    System.out.printf(" ");
                }
                iterator = iterator.nextNode;
                if (iterator.data == mayor) {
                    System.out.printf("%d ", numJugador);
                }
                numJugador += 1;
            }
            if (i + 1 != t) {
                System.out.println();
            }
        }
    }

    public static void linkedList0() {
        LinkedList0<Integer> beginNode = new LinkedList0<>(3);
        LinkedList0<Integer> secondNode = new LinkedList0<>(12);
        LinkedList0<Integer> thirdNode = new LinkedList0<>(4);
        LinkedList0<Integer> fourthNode = new LinkedList0<>(2);
        LinkedList0<Integer> fifthNode = new LinkedList0<>(24);
        beginNode.nextNode = secondNode;
        secondNode.nextNode = thirdNode;
        thirdNode.nextNode = fourthNode;
        fourthNode.nextNode = fifthNode;
        //search element O(k)
        System.out.println(beginNode.search(1000));
        beginNode.printLinkedList();
        //add element
        LinkedList0<Integer> aux = thirdNode;
        LinkedList0<Integer> intermedio = new LinkedList0<>(9999);
        secondNode.nextNode = intermedio;
        intermedio.nextNode = aux;
        beginNode.printLinkedList();
        //popElement
        intermedio.nextNode = null;
        intermedio.nextNode = fourthNode;
        beginNode.printLinkedList();

    }

    public static void linkedList() {
        LinkedList<Integer> linkedLista;
        linkedLista = new LinkedList<>();
        linkedLista.pushBack(new Node<Integer>(11));
        linkedLista.pushBack(new Node<Integer>(12));
        linkedLista.pushBack(new Node<Integer>(13));
        linkedLista.pushBack(new Node<Integer>(14));
        linkedLista.pushBack(new Node<Integer>(15));
        linkedLista.pushBack(new Node<Integer>(16));
        linkedLista.pushFront(new Node<Integer>(10));
        linkedLista.pushFront(new Node<Integer>(9));
        linkedLista.pushFront(new Node<Integer>(8));
        linkedLista.pushFront(new Node<Integer>(7));
        linkedLista.popBack();

        linkedLista.popBack();
        linkedLista.popBack();
        linkedLista.print();

    }

    public static void Stacks() {
        Stack<Integer> s = new Stack<>();
        s.push(new Node<Integer>(10));
        s.push(new Node<Integer>(11));
        s.push(new Node<Integer>(12));
        s.push(new Node<Integer>(13));

        s.print();
    }

    public static void Queue() {
        Queue<Integer> cola = new Queue<Integer>();
        cola.Enqueue(new Node<Integer>(10));
        cola.Enqueue(new Node<Integer>(11));
        cola.Enqueue(new Node<Integer>(12));
        cola.Enqueue(new Node<Integer>(13));
        Node<Integer> data = cola.Dequeue();
        System.out.println(data.data);
        cola.print();
    }

    public static void Double() {
        DoubleLinkedList<Integer> d = new DoubleLinkedList<Integer>();
        d.pushFront(new Node<Integer>(10));

        System.out.println(d.find(-10));
        d.addBefore(d.beginNode, 55);
        d.print();

    }

    public static void dinamicA() {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.print();
        a.add(3);
        a.print();
        a.add(4);
        a.print();
        a.add(5);
        a.print();
        a.add(6);
        a.print();
        a.add(7);
        a.print();
        a.add(8);
        a.print();
        a.add(9);
        a.print();
        System.out.println(a.getN() + "/" + a.getLen());
    }

    public static LinkedList<Integer> readInput(int len) {
        LinkedList<Integer> input = new LinkedList<Integer>();
        for (int i = 0; i < len; i++) {
            int a = IN.nextInt();
            input.pushBack(new Node<Integer>(a));
        }
        return input;
    }

    public static void punto1UNCODE() {
        int cases = IN.nextInt();
        for (int i = 0; i < cases; i++) {
            int n, m;
            LinkedList<Integer> nLink, mLink;
            //Lectura de datos de entrada
            n = IN.nextInt();
            nLink = readInput(n);
            m = IN.nextInt();
            mLink = readInput(m);

            if (n != 0 && m != 0) {
                nLink.mergeEnd(mLink);
                nLink.sortList();
                nLink.removeRepeats();
                nLink.print();
            } else {
                if (n == 0) {
                    mLink.sortList();
                    mLink.removeRepeats();
                    mLink.print();
                } else {
                    nLink.sortList();
                    nLink.removeRepeats();
                    nLink.print();
                }
            }
            if (i + 1 != cases) {
                System.out.println();
            }
        }
        IN.close();
    }

    private static void punto2UNCODE() {
        int n = IN.nextInt();
        Integer operaciones[] = new Integer[n];
        Integer parametros[] = new Integer[n];

        for (int i = 0; i < n; i++) {
            int op = IN.nextInt();
            operaciones[i] = op;
            if (op == 1 || op == 2 || op == 3) {
                parametros[i] = IN.nextInt();
            }
        }
        IntegerContainer contenedor = new IntegerContainer(operaciones, parametros);
        contenedor.solucion();

    }
}
