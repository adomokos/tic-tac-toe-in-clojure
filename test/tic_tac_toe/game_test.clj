(ns tic-tac-toe.game-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.game :refer :all]))

(deftest board-test
  (is (= [[:_ :_ :_][:_ :_ :_][:_ :_ :_]] board)))

(deftest print-board-test
  (testing "prints an empty tic-tac-toe board"
    (is (= "\n_ _ _ \n_ _ _ \n_ _ _ \n" (print-board board)))))

(deftest converts-step-into-coordinates-test
  (testing "A1 is [0 0]"
    (is (= [0 0] (converts-step-into-coordinates "A1"))))
  (testing "A2 is [0 1]"
    (is (= [0 1] (converts-step-into-coordinates "A2"))))
  (testing "C3 is [2 2]"
    (is (= [2 2] (converts-step-into-coordinates "C3"))))
  (testing "C4 is throwing an IllegalArgumentException"
    (is (thrown? IllegalArgumentException (converts-step-into-coordinates "C4"))))
  (testing "D3 is throwing an IllegalArgumentException"
    (is (thrown? IllegalArgumentException (converts-step-into-coordinates "D3")))))

(deftest records-moves-on-a-board
  (let [game-board (atom board)]
    (testing "for user - A1 marks the top left with `X`"
      (is (= [[:X :_ :_][:_ :_ :_][:_ :_ :_]] (swap! game-board record-move "A1" :X))))
    (testing "for computer - B2 marks the middle with `O`"
      (is (= [[:X :_ :_][:_ :O :_][:_ :_ :_]] (swap! game-board record-move "B2" :O))))
    (testing "for user - C3 marks the bottom right with `X`"
      (is (= [[:X :_ :_][:_ :O :_][:_ :_ :X]] (swap! game-board record-move "C3" :X))))))
