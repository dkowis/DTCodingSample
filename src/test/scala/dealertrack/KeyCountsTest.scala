package dealertrack

import org.junit.runner.RunWith
import org.scalatest.{FunSpec, Matchers}
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class KeyCountsTest extends FunSpec with Matchers{

  describe("summing up keys from a file") {
    it("sums up keys properly") {
      //Given a uri to a file
      val url = getClass.getResource("/keyCountFile.txt")

      //When I ask my function to sum it for me
      val result = KeyCounts.countKeys(url)

      //I should get back the proper results for my sample file
      result should equal("The total for John is 6. The total for Jane is 8.")
    }
  }
}
