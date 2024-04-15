import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine

class CombinationsOfASum {
  private def dfs(arr: Set[Int], combination: Set[Int], i: Int, tot: Int, target: Int, ans: ListBuffer[Set[Int]]): Unit = {
    if (tot == target) {
      ans += combination
      return
    }
    if (i >= arr.size || tot > target) {
      return
    }
    val current = arr.toList(i)
    dfs(arr, combination + current, i, tot + current, target, ans)
    dfs(arr, combination, i + 1, tot, target, ans)
  }

  def combinationSum(arr: Set[Int], target: Int): List[Set[Int]] = {
    val ans = ListBuffer[Set[Int]]()
    dfs(arr, Set(), 0, 0, target, ans)
    ans.toList
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    println("Enter the candidates (comma-separated): ")
    val candidatesInput = readLine().split(",").map(_.toInt).toSet
    println("Enter the target:")
    val target = readLine().toInt

    val combinationsOfASum = new CombinationsOfASum
    val result = combinationsOfASum.combinationSum(candidatesInput, target)
    println(s"Output: ${result.mkString(", ")}")
  }
}