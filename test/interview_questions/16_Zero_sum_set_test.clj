(ns interview-questions.16-Zero-sum-set-test
  (:require [clojure.test :refer :all]
            [interview-questions.16-Zero-sum-set :refer :all]))

(testing "Three sum function"

  (is (= (three-sum '(-1, 0, 1, 2, -1, -4)) '((-1 0 1) (-1 -1 2)) ))

  )