package dealertrack

import org.scalatest.{FunSpec, Matchers}

class PalindromeTest extends FunSpec with Matchers{

  describe("is a string a palindrome?") {
    it("pop is a palindrome") {
      Palindrome.isPalindrome("pop") should equal(true)
    }
    it("Ah, Satan sees Natasha. is a palindrome") {
      Palindrome.isPalindrome("Ah, Satan sees Natasha.") should equal(true)
    }
  }

}
