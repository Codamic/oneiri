(ns oneiri.views.navbar
  (:require
   [oneiri.views.grommet :refer [header box icon button title search anchor]]
   [oneiri.utils         :refer [dir-class]]
   [hellhound.core       :refer [dispatch->server]]
   [re-frame.core        :as re-frame]))


(defn navbar
  [lang]
  (let [section-title (re-frame/subscribe [:section-title])]
    [header {:full       "horizontal"
             :separator  "bottom"
             :alignSelf  "stretch"
             :flex       true
             :pad        "small"
             :size       "small"
             :className  (dir-class lang)}

     [anchor {:icon  (icon "Fan" {:size "medium"})
              :on-click #(prn "asdasd")}]

     [title @section-title]

     [box {:flex       true
           :justify    "end"
           :direction  "row"
           :responsive false}

      [anchor {:icon  (icon "Sync")
              :on-click #(dispatch->server [:fetch-articles [0 10]])}]

      [search {:inline       false
               :fill        false
               :iconAlign   "end"
               :size        "medium"
               :dropAlign   (clj->js {:right "right"})
               :placeHolder "Search"}]]]))
