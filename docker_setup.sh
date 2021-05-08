wget https://repo.anaconda.com/miniconda/Miniconda3-latest-Linux-x86_64.sh -O ~/miniconda.sh
bash ~/miniconda.sh -b -p $HOME/miniconda
source ~/miniconda/bin/activate
conda init

conda install git
git config --global user.email "rivera.lanasm@gmail.com"
git config --global user.name "Miguel Rivera-Lanas"

git pull https://github.com/rivera-lanasm/538-Riddler.git
conda env create -f environment.yml
conda activate riddler


