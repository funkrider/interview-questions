(ns interview-questions.08-Kth-frequent-string-test
  (:require [clojure.test :refer :all]
            [interview-questions.08-Kth-frequent-string :refer :all]))


(testing "kth most frequent"

  (is (= (limit -1 0 3) 0))

  (is (= (limit 4 0 3) 3))

  (is (= (limit 1 0 3) 1))

  (def test-input ["abc" "abc" "abc" "def" "def" "sdf"])

  (is (= (kth-most-frequent test-input 0) [3 "abc"]))

  (is (= (kth-most-frequent test-input 1) [3 "abc"]))

  (is (= (kth-most-frequent test-input 2) [2 "def"]))

  (is (= (kth-most-frequent test-input 3) [1 "sdf"]))

  (is (= (kth-most-frequent test-input 4) [1 "sdf"]))

  )
