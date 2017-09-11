(ns interview-questions.15-Rotate-bits-test
  (:require [clojure.test :refer :all]
            [interview-questions.15-Rotate-bits :refer :all] ))


(testing "Usage of bit rotation"

  (is (= (rotate-bit 1 2 64) 4))

  (is (= (rotate-bit 4 -2 64) 1))

  )