/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs.list;

import user.User;
import utils.Utils;

/**
 *
 * @author Daniel
 */
public class List {

    // Clase que representa nodos (usuarios)
    // Esta clase utiliza ListNodeGraph para guardar las conexiones (arcos) en la que apuntan (Siendo dirigidos o no)
    // Para ello, utilizan una cadena la cual va guardando las conexiones
    // Esta clase como representa los nodos (usuarios) también guardan información de ellos
    public ListNodeGraph chain;
    public User user;

    public List(User user) {
        this.user = user;
        this.chain = null;
    }

    public void addEdge(User destination, int weight) {
        ListNodeGraph edge = new ListNodeGraph(destination.id, weight);
        ListNodeGraph aux = chain;

        if (chain == null) {
            chain = edge;
        } else {
            while (aux.next != null) {
                aux = aux.next;
            }

            aux.next = edge;
        }

    }

    public void delEdge(User destination) {
        if (chain == null) {
            Utils.error("ERROR! No se puede borrar arcos (relación) si no hay ninguno en este vértice (usuario)", false);
        } else if (chain.key == destination.id) {
            chain = chain.next;
        } else {
            ListNodeGraph prev = chain;
            ListNodeGraph curr = chain.next;

            while (curr != null) {
                if (curr.key == destination.id) {
                    prev.next = curr.next;
                    break;
                }
                prev = curr;
                curr = curr.next;
            }
        }
    }
}
