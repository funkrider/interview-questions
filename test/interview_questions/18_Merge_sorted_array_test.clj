(ns interview-questions.18-Merge-sorted-array-test
  (:require [clojure.test :refer :all]
            [interview-questions.18-Merge-sorted-array :refer :all]))


(testing "Merge of two arrays"

  (is (= (merge-arrays
           (int-array [1 3 5 0 0 0])
           (int-array [2 4 6])
           3 3)
          [1 2 3 4 5 6])
    )

  )