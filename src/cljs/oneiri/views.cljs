(ns oneiri.views
  (:require
   [re-frame.core         :as re-frame]
   [oneiri.home.views     :as home-views]))

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-views/home]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [:active-panel])]
    (fn []
      [show-panel @active-panel])))
