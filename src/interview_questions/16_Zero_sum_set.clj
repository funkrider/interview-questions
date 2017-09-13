(ns interview-questions.16-Zero-sum-set
  (:require [clojure.math.combinatorics :as combo]))

;;; Write a function that takes a list of integers and returns
;;; a sequence of all possible groups of 3 integers from the
;;; input that sum to 0.
;;; E.g. (-1, 0, 1, 2, -1, -4) ->
;;; ( (-1, 0, 1),  (-1, -1, 2) )

;;; Note: could have used combinators library to produce combos
;;; but chose to do by hand.

(defn three-sum [xs]
  "Takes a sequence of numbers, and returns a list of
  any group of 3 that sum to zero."
  (let [c (count xs)]
    (->>
      (for   ;; iterate every permutation of items from a sequence
           [x (range (- c 2))
            y (range (inc x) (- c 1))
            z (range (inc y) c)]
        (map (partial nth xs) (list x y z))) ;; return values
      (filter #(= 0 (apply + %)))       ;; filter where sum 0
      (map sort)                        ;; sort each set
      (distinct)                        ;; return unique sets
      )
    )
  )




;;; Write a function that takes a list of integers and returns
;;; a sequence of all possible groups of 2 or more from the input
;;; that sum to 0.

;;; Using combinatorial library - first get all possible subsets
;;; => (combo/subsets [1 2 3])
;;; (() (1) (2) (3) (1 2) (1 3) (2 3) (1 2 3))
;;; Then filter to find sum 0!

(defn zero-sum-subsets [xs]
  (->> xs
    (combo/subsets)
    (filter #(and
               (seq %)
               (= 0 (apply + %)))))
  )

(defn set-permutations [xs]
  (if (= 1 (count xs))
    (list xs)
    (for [x xs
          y (set-permutations (seq (disj (set xs) x)))]
      (cons x y)
      ))
  )