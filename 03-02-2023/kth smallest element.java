/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorder = inorderTraversal(root);
        return inorder.get(k-1);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inOrder(root,res);
        return res;
    }
    public void inOrder(TreeNode root, ArrayList<Integer> res){
        if(root==null){
            return;  
        }
        inOrder(root.left,res);
        res.add(root.val);
        inOrder(root.right,res);  
    }
}