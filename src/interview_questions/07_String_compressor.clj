(ns interview-questions.07-String-compressor
  (:require [clojure.spec.alpha :as s]
            [clojure.spec.gen.alpha :as gen]))

;;; Write a function to replace sequences of the same
;;; character within a string with just the character
;;; and the count. If the result is not shorter than the
;;; original just return the original.

(defn shortest-string [a b]
  (if (<= (.length a) (.length b))
    a
    b))

(defn compressor [input]
  (loop [i (first input)
         r (rest input)
         c 1
         out [] ]
    (if (empty? r)
      (shortest-string (apply str (conj out i c)) input)
      (if (= (first r) i)
        (recur (first r) (rest r) (inc c) out)
        (recur (first r) (rest r) 1 (conj out i c)))
      ))
  )

(s/fdef compressor
  :args (s/cat :input string?)
  :ret string?
  :fn #(<= (.length (:ret %)) (.length (:args %))))