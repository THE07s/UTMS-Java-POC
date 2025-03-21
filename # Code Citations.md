# Code Citations

 

### Trigonometry.java

Source : [HaptiCap-Mapper, version 1e62f3abbeca74c63dc2b2ec9518f19f7005288e](https://github.com/redd82/HaptiCap-Mapper/tree/1e62f3abbeca74c63dc2b2ec9518f19f7005288e/src/com/company/Trigonometry.java)

```java
= Math.pow(Math.sin(deltaLat / 2), 2) +
                   Math.cos(lat1) * Math.cos(lat2) *
                   Math.pow(Math.sin(deltaLon / 2), 2);
double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
```

### Graph.java

Ce fichier Graph.java est fourni par mon professeur.

```java
/**
 * Générique classe qui utilise les HashMap pour stocker un graph en memoire.
 * Les instances de cette classe ont le même fonctionnalité que les graphes vus en TP de Structures de Données, mais
 * parce que la classe a été définie comme une classe générique, il est possible de stocker d'autre chose que des
 * entiers dans le graphe.
 *
 * @param <Node> Le type de donnée d'être stocké dans le graphe
 * @author Richard WOODWARD
 * @version 1.0
 */
public class Graph<Node> {
   ...
   /**
    * Calcule les valeurs Ford, pour ce graph, en les stockant dans un HashMap
    * @param startNode le donde de départure
    * @return HashMap qui contient les valeurs Ford
    */
   public HashMap<Node,Double> fordValues(Node startNode){…}
   ...
}
```