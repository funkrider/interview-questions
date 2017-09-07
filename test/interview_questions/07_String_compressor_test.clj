(ns interview-questions.07-String-compressor-test
  (:require [clojure.test :refer :all]
            [interview-questions.07-String-compressor :refer :all]))


(testing "text compressor"

  (is (= (shortest-string "a" "ab") "a"))

  (is (= (compressor "abcd") "abcd"))

  (is (= (compressor "aabbcccdddd") "a2b2c3d4"))

  )