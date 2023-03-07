/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw03;

public interface TreeInterface {

    /*
     * Einen Node zum Tree hinzufügen
     */
    void addNode(TreeNode node);

    /*
     * Einen Node suchen
     */
    TreeNode searchNode(TreeNode node);

    /*
     * Einen Node löschen
     */
    void deleteNode(TreeNode node);

}
