package commons

class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null) {
  fun inOrder(): List<Int> {
    val output = mutableListOf<Int>()
    fun dfs(node: TreeNode?) {
      if (node == null) {
        return;
      }

      dfs(node.left);
      output.add(node.`val`)
      dfs(node.right);
    }

    dfs(this);
    return output;
  }

  fun preOrder(): List<Int> {
    val output = mutableListOf<Int>()
    fun dfs(node: TreeNode?) {
      if (node == null) {
        return;
      }

      output.add(node.`val`)
      dfs(node.left);
      dfs(node.right);
    }

    dfs(this);
    return output;
  }

  fun postOrder(): List<Int> {
    val output = mutableListOf<Int>()
    fun dfs(node: TreeNode?) {
      if (node == null) {
        return;
      }

      dfs(node.left);
      dfs(node.right);
      output.add(node.`val`)
    }

    dfs(this);
    return output;
  }


}