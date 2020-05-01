
package analytic

/**

https://www.semion.io/doc/on-a-uniformly-random-chord-diagram-and-its-intersection-graph



Tn(x) --> generating function yielding polynomial with coefficients, Tnk --> number of ways of choosing n pairs of points among 2n
general points suchh that there are k intersections 
 
term 1: an+j, n-j  = (2j+1)/(n+j+1) * ( 2n n+ j)

 */



class RiordanGeneratingFunction(val num_chords: Int) {

    def combinations(n: Int, k: Int): Int = {

    if (k == 0 || k == n) {
    1} else {
    combinations(n - 1, k - 1) + combinations(n - 1, k)
      }
    }


    def ballot_num(n: Int, j: Int): Double = {

        val t1: Double = (2.0*j +1.0)/(n + j + 1.0)
        
        val t2: Double = combinations(2*n, n+j)
        t1*t2 
    }



    }    
