
import analytic.RiordanGeneratingFunction

object ChordIntersectionDistribution {

    def main(args: Array[String]) {
        
        val analytic_sol = RiordanGeneratingFunction
        val analytic_distribution = analytic_sol.RiordanPolynomial(order = 2)
        println(analytic_distribution)
    }
}