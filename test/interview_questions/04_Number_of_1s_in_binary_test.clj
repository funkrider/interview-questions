(ns interview-questions.04-Number-of-1s-in-binary-test
  (:require [clojure.test :refer :all]
            [interview-questions.04-Number-of-1s-in-binary :refer :all]))

(testing "Bind binary number of 1's used in the number"

  (is (= 0 (ones 0)))
  (is (= 1 (ones 2)))
  (is (= 2 (ones 3)))
  (is (= 3 (ones 7)))
  (is (= 1 (ones 8)))
  (is (= 2 (ones 9)))

  )
