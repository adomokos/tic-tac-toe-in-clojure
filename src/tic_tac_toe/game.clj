(ns tic-tac-toe.game)

(def board
  [[:_ :_ :_][:_ :_ :_][:_ :_ :_]])

(defn print-board [board]
  (let [print-board-line
        (fn [line]
          (apply str (map #(str (name %) " ") line)))]
  (str "\n"
    (apply str (map #(str (print-board-line %) "\n") board)))))

(defn- validate-coordinates [[x y]]
  (let [valid-coordinate? (fn [coordinate]
                              (contains? [0 1 2] coordinate))]
  (if (and (valid-coordinate? x) (valid-coordinate? y))
    [x y]
    (throw (IllegalArgumentException. "Incorrect user input")))))

(defn converts-step-into-coordinates [step]
  (let [parsed-string (seq step)
        row (first parsed-string)
        col (last parsed-string)
        x-coordinate (cond
                        (= row \A) 0
                        (= row \B) 1
                        (= row \C) 2
                          :else 4)
        y-coordinate (-> col str Integer/parseInt dec)]
    (validate-coordinates [x-coordinate y-coordinate])))

(defn record-move [board step mark]
  (let [coordinates (converts-step-into-coordinates step)
        x (first coordinates)
        y (last coordinates)]
    (-> board (assoc-in [x y] mark))))
