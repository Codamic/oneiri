(ns oneiri.home.views
  (:require [re-frame.core :as re-frame]
            [oneiri.home.events]
            [oneiri.home.subs]))

(defn home
  []
  [:div
   [:input {:on-change #(re-frame/dispatch [:oneiri.home.events/set-q (-> % .-target .-value)])}]
   [:button {:on-click #(re-frame/dispatch [:oneiri.home.events/search])} "Search"]])
