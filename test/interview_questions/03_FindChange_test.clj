(ns interview-questions.03-FindChange-test
  (:require [clojure.test :refer :all]
            [interview-questions.03-FindChange :refer :all]))

(testing "Helper functions"

  (is (= (find-equal-or-first-lower #{1 2 10 25} 99) 25))
  (is (= (find-equal-or-first-lower #{1 2 10 25} 25) 25))

  (is (= (find-equal-or-first-lower #{1 2 10 25} 24) 10))
  (is (= (find-equal-or-first-lower #{1 2 10 25} 10) 10))

  (is (= (find-equal-or-first-lower #{1 2 10 25} 2) 2))
  (is (= (find-equal-or-first-lower #{1 2 10 25} 1) 1))

  )

(testing "Find change"

  (is (= (find-change #{1 2 10 25} 100) [25 25 25 25]))
  (is (= (find-change #{1 2 10 25} 99) [25 25 25 10 10 2 2]))
  (is (= (find-change #{1 2 10 25} 98) [25 25 25 10 10 2 1]))
  (is (= (find-change #{1 2 10 25} 25) [25]))
  (is (= (find-change #{1 2 10 25} 24) [10 10 2 2]))

  )