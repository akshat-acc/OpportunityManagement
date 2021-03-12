import { ComponentFixture, TestBed } from '@angular/core/testing';

import { YoYChartComponent } from './yoy-chart.component';

describe('YoYChartComponent', () => {
  let component: YoYChartComponent;
  let fixture: ComponentFixture<YoYChartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ YoYChartComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(YoYChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
