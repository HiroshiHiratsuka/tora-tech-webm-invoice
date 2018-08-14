git config --global user.email "hiratsukah@systena.co.jp"
git config --global user.name "hiratsuka"
exit
echo "tora-tech-webm-invoice" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/HiroshiHiratsuka/tora-tech-webm-invoice.git
git push -u origin master
git branch -a
git checkout -b develop
git checkout -b feature
git branch -a
git push -u origin develop
git push -u origin feature
git branch -a
env
env
