
import analytic.RiordanGeneratingFunction

object ChordIntersectionDistribution {

    def main(args: Array[String]) {
        
        val analytic_sol = RiordanGeneratingFunction
        
        val t = analytic_sol.ballot_num(n = 2, j = 2)
        
        val n = analytic_sol.RiordanPolynomial(order = 2)
        println(n)
    }
}