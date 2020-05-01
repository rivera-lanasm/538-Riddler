
import analytic.RiordanGeneratingFunction

object ChordIntersectionDistribution {

    def main(args: Array[String]) {
        
        val analytic_sol = new RiordanGeneratingFunction(num_chords = 2)
        
        val t = analytic_sol.ballot_num(n = 2, j = 2)
        println(t)

    }
}