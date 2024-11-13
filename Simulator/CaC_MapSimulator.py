#%% 마우스로 선 그리기
import pygame as pg

import numpy as np
import os
import itertools


#%% Game System

def load_image(file):
    """loads an image, prepares it for play"""
    file = os.path.join(os.path.split(os.path.abspath(__file__))[0], "Data", file)
    try:
        surface = pg.image.load(file)
    except:
        pg.quit()
        raise SystemExit(f'Could not load image "{file}"')
    return surface.convert_alpha()


#%%
class Env_CaC():
    def __init__(self, grid_num=(10,10)):
        self.grid_num = grid_num
        
        self.mouse_x = 0
        self.mouse_y = 0
        self.MX = 0
        self.MY = 0
        
        self.obstacle = []
        self.wall = []
        self.wall.append((-1,-1))
        self.wall.append((-1,grid_num[1]))
        self.wall.append((grid_num[0],-1))
        self.wall.append(grid_num)
        for wall in itertools.product(np.arange(0,grid_num[0]),np.array([-1,grid_num[1]])):
            self.wall.append(wall)
        for wall in itertools.product(np.array([-1,grid_num[0]]),np.arange(0,grid_num[1])):
            self.wall.append(wall)
        
        self.render_initialize()
    
    
    def step(self, action):
        self.MX = (self.mouse_x-self.grid_SP[0])//self.grid_size
        self.MY = (self.mouse_y-self.grid_SP[1])//self.grid_size
        
        
        if (action==0):
            self.obstacle = []
        if (action==1):
            pos = (self.MX, self.MY)
            if pos in self.obstacle: # 이미 설치되었다면 지움
                self.obstacle.remove(pos)
            else: # 없다면 설치
                if ((pos[0]<self.MX_max) and (pos[1]<self.MY_max)) and ((pos[0]>=0) and (pos[1]>=0)):
                    self.obstacle.append(pos)
        
    
    def render_initialize(self):
        pg.init()
        pg.display.set_caption('CaC')
        
        # Screen 생성
        self.screen = pg.display.set_mode((1080,1080))
        
        # clock 생성
        self.G_clock = pg.time.Clock()
        
        # 그리드 설정
        self.grid_size = 32
        self.grid_SP = (64,64) # 그리드가 시작되는 위치, 즉 그리드 왼쪽 상단의 위치
        self.grid_EP = (self.grid_SP[0]+self.grid_num[0]*self.grid_size, 
                        self.grid_SP[1]+self.grid_num[1]*self.grid_size)
        
        self.MX_max = self.grid_num[0] # 미만
        self.MY_max = self.grid_num[1] # 미만
        
        # 스프라이트 생성
        self.spr_select = pg.transform.scale(load_image("Grid_Selected.png"), (self.grid_size,self.grid_size))
        self.spr_block = pg.transform.scale(load_image("Grid_White.png"), (self.grid_size,self.grid_size))
        self.spr_wall = pg.transform.scale(load_image("Grid_Red.png"), (self.grid_size,self.grid_size))
        self.spr_predator = pg.transform.scale(load_image("Spr_Yellow.png"), (self.grid_size//2,self.grid_size//2))
        self.spr_prey = pg.transform.scale(load_image("Spr_Cyan.png"), (self.grid_size//2,self.grid_size//2))
        
        # 초기 렌더
        self.screen.fill((0,0,0)) # 화면 검은색으로
    
    
    def render(self):
        self.screen.fill((0,0,0)) # 화면 검은색으로
        
        self.MX = (self.mouse_x-self.grid_SP[0])//self.grid_size
        self.MY = (self.mouse_y-self.grid_SP[1])//self.grid_size
        
        ## Wall Block
        for pos in self.wall:
            self.screen.blit(self.spr_wall,(pos[0]*self.grid_size+self.grid_SP[0],
                                            pos[1]*self.grid_size+self.grid_SP[1],
                                            self.grid_size, self.grid_size))
        
        # Select Block
        if ((self.MX<self.MX_max) and (self.MY<self.MY_max)) and ((self.MX>=0) and (self.MY>=0)):
            self.screen.blit(self.spr_select,(self.grid_SP[0]+self.grid_size*self.MX,
                                              self.grid_SP[1]+self.grid_size*self.MY,
                                              self.grid_size, self.grid_size))
        
        # Obstacle Block
        for pos in self.obstacle:
            self.screen.blit(self.spr_block,(pos[0]*self.grid_size+self.grid_SP[0],
                                             pos[1]*self.grid_size+self.grid_SP[1],
                                             self.grid_size, self.grid_size))
        
        self.G_clock.tick(G_FPS)
        pg.display.update()
    
    
    def close(self):
        pg.quit()


#%%
map_x = 10
map_y = 10

G_FPS = 5

env = Env_CaC(grid_num=(map_x,map_y))

while True:
    env.render()
    for event in pg.event.get():
        if event.type == pg.QUIT:
            env.close()
            break
        if event.type == pg.MOUSEMOTION: # 마우스의 움직임이 감지되면
            env.mouse_x, env.mouse_y = pg.mouse.get_pos() # 마우스 x,y좌표값 저장
        if event.type == pg.MOUSEBUTTONDOWN: # 마우스 클릭을 하면
            if event.button == 1: # 왼쪽 클릭
                env.step(1)
            elif event.button == 3: # 오른쪽 클릭
                env.step(0)