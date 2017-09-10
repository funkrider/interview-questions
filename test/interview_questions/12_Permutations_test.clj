(ns interview-questions.12-Permutations-test
  (:require [clojure.test :refer :all]
            [interview-questions.12-Permutations :refer :all]))


(testing "Usage of permutation"

  (is (= (permutation '(1)) '((1))))

  (is (= (permutation '(1 2)) '((1 2) (2 1)) ))

  (is (= (permutation '(1 2 3)) '((1 2 3) (1 3 2) (2 1 3) (2 3 1) (3 1 2) (3 2 1))))

  )