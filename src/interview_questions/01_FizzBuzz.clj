(ns interview-questions.01-FizzBuzz
  (:require [clojure.spec.alpha :as s]))

;; Output numbers from 1 to x. If the number
;; is divisible by 3, replace it with Fizz.
;; If it is divisible by 5, replace it with Buzz.
;; If it is divisible by 5 and 3 FizzBuzz
;; (fizz-buzz 15)
;;=> (1 2 "fizz" 4 "buzz" "fizz" 7 8 "fizz" "buzz"
;;    11 "fizz" 13 14 "fizzbuzz")

(defn divisible-by? [divisor num]
  (if (or (nil? divisor)
          (nil? num)
          (= 0 divisor)
          (= 0 num)
          (not (nat-int? divisor))
          (not (nat-int? num)))
    false
    (= (mod num divisor) 0)))

(def divisible-by-3? (partial divisible-by? 3))

(def divisible-by-5? (partial divisible-by? 5))

(defn positive-numbers
  ([] (positive-numbers 1))
  ([n] (lazy-seq (cons n (positive-numbers (inc n))))))

(defn fizz-buzz-replace [n]
  (let [by-3 (divisible-by-3? n)
        by-5 (divisible-by-5? n)]
       (cond (and by-3 by-5)  "fizzbuzz"
             by-3 "fizz"
             by-5 "buzz"
             :else n)
             )
  )

(defn fizz-buzz [x]
  (map fizz-buzz-replace (take x (positive-numbers)))
  )