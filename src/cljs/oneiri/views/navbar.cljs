(ns oneiri.views.navbar
  (:require
   [oneiri.views.grommet :refer [header box icon button title search anchor]]
   [oneiri.utils         :refer [dir-class]]
   [hellhound.core       :refer [dispatch->server]]))


(defn navbar
  [lang]
  [header {:full       "horizontal"
           :alignSelf  "stretch"
           :flex       true
           :pad        "small"
           :size       "small"
           :className  (dir-class lang)}

   [title
    [anchor {:icon  (icon "Fan" {:size "medium"})
             :on-click #(prn "asdasd")}]]

   [anchor {:icon  (icon "Sync")
            :on-click #(dispatch->server [:fetch-articles [0 10]])}]

   [box {:flex       true
         :justify    "end"
         :direction  "row"
         :responsive false}
    [search {:inline      true
             :fill        true
             :iconAlign   "start"
             :size        "medium"
             :dropAlign   (clj->js {:right "right"})
             :placeHolder "Search"}]]
   [anchor {:icon  (icon "StandardsPerformance")
            :on-click #(js/alert "asd")}]])
