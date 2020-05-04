(ns interview-questions.05-Stack-push-pop-max-test
  (:require [clojure.test :refer :all]
            [interview-questions.05-Stack-push-pop-max :refer :all]))

(testing "Custom Stack Class with push pop and max"

  (is (= interview_questions.demo (type (new interview_questions.demo))))
  (is (= 4 (.max (doto (new interview_questions.demo)
                   (.push 1)
                   (.push 4)
                   (.push 2)
                   (.push 3)))))
  (is (= 4 (.max (doto (new interview_questions.demo)
                   (.push 1)
                   (.push 4)
                   (.push 2)
                   (.push 3)
                   (.pop)))))
  (is (= 4 (.max (doto (new interview_questions.demo)
                   (.push 1)
                   (.push 4)
                   (.push 2)
                   (.push 3)
                   (.pop)
                   (.pop)))))
  (is (= 1 (.max (doto (new interview_questions.demo)
             (.push 1)
             (.push 4)
             (.push 2)
             (.push 3)
             (.pop) ; -> 2
             (.pop) ; -> 4
             (.pop) ; -> 1
             )))))
