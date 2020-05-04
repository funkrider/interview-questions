(ns interview-questions.01-FizzBuzz
  (:require [clojure.spec.alpha :as s]))

;; Output numbers from 1 to x. If the number
;; is divisible by 3, replace it with Fizz.
;; If it is divisible by 5, replace it with Buzz.
;; If it is divisible by 5 and 3 FizzBuzz
;; (fizz-buzz 15)
;;=> (1 2 "fizz" 4 "buzz" "fizz" 7 8 "fizz" "buzz"
;;    11 "fizz" 13 14 "fizzbuzz")

(defn fizz-buzz-basic [n]
  (map #(cond
          (zero? (mod % (* 3 5)))
          "fizzbuzz"

          (zero? (mod % 3))
          "fizz"

          (zero? (mod % 5))
          "buzz"

          :else %)
       (range 1 n)))

#_(fizz-buzz-basic 16)

(defn divisible-by?
  "Given a divisor and number returns true where
  the number is a multiple of the divisor and false
  where it is not. It will return false where the divisor
  or the number are not natural integers and greater
  than zero."
  [divisor num]
  (if (or (nil? divisor)
          (nil? num)
          (= 0 divisor)
          (= 0 num)
          (not (nat-int? divisor))
          (not (nat-int? num)))
    false
    (= (mod num divisor) 0)))

(defn fizz-buzz-replace
  [n]
  (let [by-3 (divisible-by? 3 n)
        by-5 (divisible-by? 5 n)]
    (cond (and by-3 by-5)  "fizzbuzz"
          by-3 "fizz"
          by-5 "buzz"
          :else n)))

(defn fizz-buzz-by-replace [n]
  (map fizz-buzz-replace (range 1 n)))

(defn positive-numbers
  "This is a for-fun  re-implementation of range. More of an experiment
  to see how lazy-seq and cons work."
  ([] (positive-numbers 1))
  ([n] (lazy-seq (cons n (positive-numbers (inc n))))))

(defn fizz-buzz-by-replace-pos-num [x]
  (map fizz-buzz-replace (take x (positive-numbers))))

(def replacements [[3 "fizz"] [5 "buzz"]])

(defn replace-by-r-map
  "Takes a vector of possible replacements and a target value.
  Each replacement is a vector where the first item is the possible divisor
  and the second the replacement string. Where the target value
  matches more than one replacement the results are concatenated.
  Where the target is not divislbe by any replacement it is returned
  unchanged."
  [r-map i]
  (let [new-val (reduce (fn [acc [k v]]
                          (if (zero? (mod i k))
                            (str acc v)
                            acc))
                        nil
                        r-map)]
    (or new-val i)))

#_(replace-by-r-map replacements 15)

;; Just to show that we can use this function as a transducer
(def replace-by-r-map-xf (map (partial replace-by-r-map replacements)))

#_(sequence replace-by-r-map-xf (range 1 20))
