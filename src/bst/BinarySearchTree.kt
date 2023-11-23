package bst

class TreeNode(var value: Int, var left: TreeNode?, var right: TreeNode?) {}

class BinarySearchTree {
  var root: TreeNode;

  constructor(root: TreeNode) {
    this.root = root;
  }

  constructor(numbers: Array<Int>) {
    this.root = TreeNode(numbers[0], null, null);
    for (i in 1..numbers.size - 1) {
      this.insert(numbers[i]);
    }
  }

  fun equals(tree: BinarySearchTree): Boolean {
    return nodesEquals(this.root, tree.root);
  }

  private fun nodesEquals(a: TreeNode?, b: TreeNode?): Boolean {
    if (a == null || b == null) {
      return a == b
    }

    if (a.value != b.value) {
      return false;
    }

    if (!nodesEquals(a.left, b.left)) {
      return false;
    }

    if (!nodesEquals(a.right, b.right)) {
      return false;
    }

    return true;
  }

  fun insert(value: Int) {
    var curr : TreeNode? = this.root;

    while (curr != null) {
      if (curr.value > value) {
        if (curr.left == null) {
          curr.left = TreeNode(value, null, null);
          return;
        } else {
          curr = curr.left;
        }
      } else if (curr.value < value) {
        if (curr.right == null) {
          curr.right = TreeNode(value, null, null);
          return;
        } else {
          curr = curr.right;
        }
      } else {
        return;
      }
    }
  }

  fun inOrder(): ArrayList<Int> {
    val values = ArrayList<Int>();

    fun traverse(node: TreeNode?) {
      if (node == null) {
        return;
      }

      traverse(node.left);
      values.add(node.value);
      traverse(node.right);
    }

    traverse(this.root);
    return values;
  }
}
