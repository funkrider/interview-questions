(ns interview-questions.06-Anagram
  (:require [clojure.spec.alpha :as s]
            [clojure.spec.gen.alpha :as gen]))

;;; Write a function to determine if one string is an
;;; anagram of another. Assume all lower western chars.
;;; Ignore spaces and punctuation.
;;; In java etc. maps can not be directly compared.
;;; You should use an array where index = char->int
;;; and count is value. Increment for a and decrement
;;; for b. Then if any val == 0 we fail.

(defn char-range
  "Gen a start and end char will construct a sequence
  of all the chars inside that range, ending inclusive."
  [start end]
  (map char (range (int start) (inc (int end)))))

(defn char-range-hash-set
  "Given a start and end char will construct a hash set of
  each char inside that range, ending inclusive."
  [start end]
  (apply hash-set (char-range start end)))

(defn char-count
  "Makes a count of each char present as a map {a 1, b 2 etc.}"
  [x]
  (reduce (fn [acc v]
            (let [acc-v (get acc v 0)]
              (assoc acc v (inc acc-v))))
          {}
          x))

(defn is-anagram?
  "Given two stings a and b, will count each char within each
  string and return true where there is an identical count
  of characters in each, otherwise false. "
  ( [a b] (is-anagram? a b \a \z) )
  ( [a b s e]
    (let [ac (->> a
             (.toLowerCase)
             (filter (char-range-hash-set s e))
             (char-count))  ;; same as frequencies func.
          bc (->> b
             (.toLowerCase)
             (filter (char-range-hash-set s e))
             (char-count))] ;; same as frequencies func.
    (= ac bc))))
